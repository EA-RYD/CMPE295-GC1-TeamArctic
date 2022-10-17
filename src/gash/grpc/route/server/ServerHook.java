package gash.grpc.route.server;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import route.Route;
import route.RouteServiceGrpc;

import com.google.protobuf.Struct.Builder;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;

import java.util.concurrent.LinkedBlockingDeque;

import org.json.JSONObject;

// framework 
public class ServerHook {
    private LinkedBlockingDeque<JSONObject> que;

    private static long clientID = 1; //prob doesnt go here
    private static int port = 2345;

    //json to proto route used to make request
    private static final Route constructRequest(JSONObject json) {
        route.Route r = null;
        try {
            Route.Builder bld = Route.newBuilder();
            JsonFormat.parser().merge(json.toString(), bld);
            //bld.setPayload(ByteString.copyFrom(((String) json.get("Payload")).getBytes()));
            r = bld.build();
        } catch (Exception e) {
            System.err.println("Invalid Request Construction: \n" + e);
        }
        return r;
    }

    // original client uses this 
    //maybe just adds request to queue?
    // put thread places request in server
    public void request(JSONObject json) {


    }

    // actually makes request to server 
    // take thread sends request
    private void processRequest() {
        //TODO need actual IP and Port, just using from example for now
        ManagedChannel ch = ManagedChannelBuilder.forAddress("localhost", ServerHook.port).usePlaintext().build();
		RouteServiceGrpc.RouteServiceBlockingStub stub = RouteServiceGrpc.newBlockingStub(ch);
    }

    // stop server
    protected void stop() {
		//TODO
	}



}
