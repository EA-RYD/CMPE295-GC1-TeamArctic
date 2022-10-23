// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route.proto

package route;

public interface RouteOrBuilder extends
    // @@protoc_insertion_point(interface_extends:route.Route)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *Used to reference the message being sent
   * </pre>
   *
   * <code>int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>int64 origin = 2;</code>
   */
  long getOrigin();

  /**
   * <code>int64 destination = 3;</code>
   */
  long getDestination();

  /**
   * <code>string path = 4;</code>
   */
  java.lang.String getPath();
  /**
   * <code>string path = 4;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>int32 workType = 5;</code>
   */
  int getWorkType();

  /**
   * <pre>
   *Generalized
   * </pre>
   *
   * <code>bytes payload = 6;</code>
   */
  com.google.protobuf.ByteString getPayload();
}
