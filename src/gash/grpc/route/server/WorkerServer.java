package gash.grpc.route.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import route.RouteServiceGrpc;
import route.RouteServiceGrpc.RouteServiceImplBase;

public class WorkerServer extends RouteServiceImplBase {
    private Server svr;
    private List<Worker> workers = new ArrayList<>();
    protected static int serverID;
    protected static int leaderID;
    protected RouteServiceGrpc.RouteServiceStub comm;
    private Worker hbManager;

    /**
	* Configuration of the server's identity, port, and role
	*/
	private static Properties getConfiguration(final File path) throws IOException {
		if (!path.exists())
			throw new IOException("missing config file for worker server");

		Properties rtn = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			rtn.load(fis);
            String tmp = rtn.getProperty("server.id");
            serverID = Integer.parseInt(tmp);
            String ld = rtn.getProperty("server.leader");
            leaderID = Integer.parseInt(ld);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}

		return rtn;
	}
    
    public static void main(String[] args) throws Exception {

        String path = args[0];
        try {
            Properties conf = WorkerServer.getConfiguration(new File(path));
            RouteServer.configure(conf);
            
            final WorkerServer ws = new WorkerServer();
            ws.setup();
            ws.start();
            ws.blockUntilShutdown();
        } catch (IOException e) {
            System.out.println("failed to load configuration");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void setup() {
        ManagedChannel ch = ManagedChannelBuilder.forAddress("localhost", RouteServer.getInstance().getServerDestination()).usePlaintext().build();
		comm = RouteServiceGrpc.newStub(ch);
		System.out.println("Worker server " + serverID + " connected to leader " + leaderID);
		System.out.println("comm set up successfully? " + (comm != null));
    }

    private void start() throws Exception {
        initializeWorkers();
        initializeHBManager();
		// svr = ServerBuilder.forPort(RouteServer.getInstance().getServerPort()).addService(new WorkerServer())
		svr = ServerBuilder.forPort(RouteServer.getInstance().getServerPort()).addService(this)
				.build();

		System.out.println("-- starting worker server " + serverID + " on port " + RouteServer.getInstance().getServerPort());
		svr.start();

        for (Worker w : workers) {
			System.out.println("starting worker " + w.getId());
            w.start();
        }

		this.hbManager.start();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				WorkerServer.this.stop();
			}
		});
	}

    protected void stop() {
		svr.shutdown();
	}

    private void blockUntilShutdown() throws Exception {
		/* TODO what clean up is required? */
		svr.awaitTermination();
	}
    /**
	 * server received a message!
	 * transform this to a delay response (delay processing?)
	 * responseObserver used to send results
	 * can send acknowledgement of request was accepted and another of the results of the request
	 */
	public void request(route.Route request, StreamObserver<route.Route> responseObserver) {
		// System.out.println("------ Testing received request from client");
		// System.out.println("------ Request destination " + request.getDestination());
		// System.out.println("------ Request type " + request.getWorkType());
		// System.out.println("------ Request origin " + request.getOrigin());
		// System.out.println("------ current server " + serverID);
        // check if current server is the destination
        if (request.getDestination() == serverID) {
            // deal with the HB request
            if (request.getWorkType() == 5) {
                System.out.println("Received HB request from " + request.getOrigin());
                var HBresponse = processHB(request);
                
                // send hb back to leader
                responseObserver.onNext(HBresponse);
                responseObserver.onCompleted();
            } else{
                var w = new Work(responseObserver, request);
                enqueueAsWork(w);
            }
        } else {
            // This is not the destination, forward the request to the next server
			System.out.println("-- Forwarding request to next server: " + request.getDestination() + "\n\n");
			comm.request(request, responseObserver);
        }
	}

    protected route.Route processHB(route.Route msg) {
        route.Route.Builder hb = route.Route.newBuilder();
        hb.setOrigin(serverID);
        hb.setDestination(leaderID);
        hb.setWorkType(5);
        // TODO: get the playload for the HB 
		String payload = String.valueOf(this.hbManager.getSleepTimeAllWorkers());

        hb.setPayload(ByteString.copyFromUtf8(payload));
        return hb.build();
    }

    private void initializeWorkers() {
		//Fill the list with 4 workers
		for (int i = 0; i < 4; i++) {
			Worker worker = new Worker(this, Worker.WorkerType.Worker);

			workers.add(worker);
		}

		//Comment this out since this loop is already residing in the workerServer's start method
		/*for (Worker w : workers) {
			w.start();
		}*/
	}

	private void initializeHBManager() {
		this.hbManager = new Worker(this, Worker.WorkerType.HBManager);

		this.hbManager.setWorkers(workers);
	}

	//Decide which worker will handle the request based on heartbeats
	public void enqueueAsWork(Work w) {
		int lowestSleepTime = Integer.MAX_VALUE;

		int index = 0;
		int workerIndexLowestSleep = index;
		//Go through each worker's heartbeats
		for (Work hb : this.hbManager.getWorks()) {
			//Convert byte array to string representation
			String hbStatus = new String(hb.payload);

			String[] hbStatusArr = hbStatus.split(" ");

			int currentWorkerId = Integer.parseInt(hbStatusArr[0]);
			int queueSize = Integer.parseInt(hbStatusArr[1]);
			int cumulativeSleepTime = Integer.parseInt(hbStatusArr[2]);

			//If the worker's queue size is at max, then skip to the next worker heartbeat
			if (queueSize >= Worker.maxWorkSize) {
				index++;
				continue;
			}
			else {
				if (cumulativeSleepTime < lowestSleepTime) {
					lowestSleepTime = cumulativeSleepTime;
					workerIndexLowestSleep = index;
				}
			}
			index++;
		}

		//Add the work to the worker with the least sleep time
		workers.get(workerIndexLowestSleep).addWork(w);
	}
}