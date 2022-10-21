// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route.proto

package route;

/**
 * <pre>
 *Data structure definition
 * TODO MENTION TO OTHERS THAT ERIC ADDED TYPE
 * </pre>
 *
 * Protobuf type {@code route.Route}
 */
public final class Route extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:route.Route)
    RouteOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Route.newBuilder() to construct.
  private Route(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Route() {
    path_ = "";
    payload_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Route();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Route(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            id_ = input.readInt64();
            break;
          }
          case 16: {

            origin_ = input.readInt64();
            break;
          }
          case 24: {

            destination_ = input.readInt64();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            path_ = s;
            break;
          }
          case 40: {

            workType_ = input.readInt32();
            break;
          }
          case 50: {

            payload_ = input.readBytes();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return route.RouteOuterClass.internal_static_route_Route_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return route.RouteOuterClass.internal_static_route_Route_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            route.Route.class, route.Route.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <pre>
   *Used to reference the message being sent
   * </pre>
   *
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }

  public static final int ORIGIN_FIELD_NUMBER = 2;
  private long origin_;
  /**
   * <code>int64 origin = 2;</code>
   * @return The origin.
   */
  @java.lang.Override
  public long getOrigin() {
    return origin_;
  }

  public static final int DESTINATION_FIELD_NUMBER = 3;
  private long destination_;
  /**
   * <code>int64 destination = 3;</code>
   * @return The destination.
   */
  @java.lang.Override
  public long getDestination() {
    return destination_;
  }

  public static final int PATH_FIELD_NUMBER = 4;
  private volatile java.lang.Object path_;
  /**
   * <code>string path = 4;</code>
   * @return The path.
   */
  @java.lang.Override
  public java.lang.String getPath() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      path_ = s;
      return s;
    }
  }
  /**
   * <code>string path = 4;</code>
   * @return The bytes for path.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPathBytes() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      path_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WORKTYPE_FIELD_NUMBER = 5;
  private int workType_;
  /**
   * <code>int32 workType = 5;</code>
   * @return The workType.
   */
  @java.lang.Override
  public int getWorkType() {
    return workType_;
  }

  public static final int PAYLOAD_FIELD_NUMBER = 6;
  private com.google.protobuf.ByteString payload_;
  /**
   * <pre>
   *Generalized
   * </pre>
   *
   * <code>bytes payload = 6;</code>
   * @return The payload.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getPayload() {
    return payload_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (origin_ != 0L) {
      output.writeInt64(2, origin_);
    }
    if (destination_ != 0L) {
      output.writeInt64(3, destination_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(path_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, path_);
    }
    if (workType_ != 0) {
      output.writeInt32(5, workType_);
    }
    if (!payload_.isEmpty()) {
      output.writeBytes(6, payload_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (origin_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, origin_);
    }
    if (destination_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, destination_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(path_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, path_);
    }
    if (workType_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, workType_);
    }
    if (!payload_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(6, payload_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof route.Route)) {
      return super.equals(obj);
    }
    route.Route other = (route.Route) obj;

    if (getId()
        != other.getId()) return false;
    if (getOrigin()
        != other.getOrigin()) return false;
    if (getDestination()
        != other.getDestination()) return false;
    if (!getPath()
        .equals(other.getPath())) return false;
    if (getWorkType()
        != other.getWorkType()) return false;
    if (!getPayload()
        .equals(other.getPayload())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + ORIGIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getOrigin());
    hash = (37 * hash) + DESTINATION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDestination());
    hash = (37 * hash) + PATH_FIELD_NUMBER;
    hash = (53 * hash) + getPath().hashCode();
    hash = (37 * hash) + WORKTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getWorkType();
    hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
    hash = (53 * hash) + getPayload().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static route.Route parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static route.Route parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static route.Route parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static route.Route parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static route.Route parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static route.Route parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static route.Route parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static route.Route parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static route.Route parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static route.Route parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static route.Route parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static route.Route parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(route.Route prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *Data structure definition
   * TODO MENTION TO OTHERS THAT ERIC ADDED TYPE
   * </pre>
   *
   * Protobuf type {@code route.Route}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:route.Route)
      route.RouteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return route.RouteOuterClass.internal_static_route_Route_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return route.RouteOuterClass.internal_static_route_Route_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              route.Route.class, route.Route.Builder.class);
    }

    // Construct using route.Route.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = 0L;

      origin_ = 0L;

      destination_ = 0L;

      path_ = "";

      workType_ = 0;

      payload_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return route.RouteOuterClass.internal_static_route_Route_descriptor;
    }

    @java.lang.Override
    public route.Route getDefaultInstanceForType() {
      return route.Route.getDefaultInstance();
    }

    @java.lang.Override
    public route.Route build() {
      route.Route result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public route.Route buildPartial() {
      route.Route result = new route.Route(this);
      result.id_ = id_;
      result.origin_ = origin_;
      result.destination_ = destination_;
      result.path_ = path_;
      result.workType_ = workType_;
      result.payload_ = payload_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof route.Route) {
        return mergeFrom((route.Route)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(route.Route other) {
      if (other == route.Route.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (other.getOrigin() != 0L) {
        setOrigin(other.getOrigin());
      }
      if (other.getDestination() != 0L) {
        setDestination(other.getDestination());
      }
      if (!other.getPath().isEmpty()) {
        path_ = other.path_;
        onChanged();
      }
      if (other.getWorkType() != 0) {
        setWorkType(other.getWorkType());
      }
      if (other.getPayload() != com.google.protobuf.ByteString.EMPTY) {
        setPayload(other.getPayload());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      route.Route parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (route.Route) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_ ;
    /**
     * <pre>
     *Used to reference the message being sent
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <pre>
     *Used to reference the message being sent
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Used to reference the message being sent
     * </pre>
     *
     * <code>int64 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private long origin_ ;
    /**
     * <code>int64 origin = 2;</code>
     * @return The origin.
     */
    @java.lang.Override
    public long getOrigin() {
      return origin_;
    }
    /**
     * <code>int64 origin = 2;</code>
     * @param value The origin to set.
     * @return This builder for chaining.
     */
    public Builder setOrigin(long value) {
      
      origin_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 origin = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOrigin() {
      
      origin_ = 0L;
      onChanged();
      return this;
    }

    private long destination_ ;
    /**
     * <code>int64 destination = 3;</code>
     * @return The destination.
     */
    @java.lang.Override
    public long getDestination() {
      return destination_;
    }
    /**
     * <code>int64 destination = 3;</code>
     * @param value The destination to set.
     * @return This builder for chaining.
     */
    public Builder setDestination(long value) {
      
      destination_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 destination = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDestination() {
      
      destination_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object path_ = "";
    /**
     * <code>string path = 4;</code>
     * @return The path.
     */
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        path_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string path = 4;</code>
     * @return The bytes for path.
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string path = 4;</code>
     * @param value The path to set.
     * @return This builder for chaining.
     */
    public Builder setPath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      path_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string path = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPath() {
      
      path_ = getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    /**
     * <code>string path = 4;</code>
     * @param value The bytes for path to set.
     * @return This builder for chaining.
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      path_ = value;
      onChanged();
      return this;
    }

    private int workType_ ;
    /**
     * <code>int32 workType = 5;</code>
     * @return The workType.
     */
    @java.lang.Override
    public int getWorkType() {
      return workType_;
    }
    /**
     * <code>int32 workType = 5;</code>
     * @param value The workType to set.
     * @return This builder for chaining.
     */
    public Builder setWorkType(int value) {
      
      workType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 workType = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearWorkType() {
      
      workType_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     *Generalized
     * </pre>
     *
     * <code>bytes payload = 6;</code>
     * @return The payload.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getPayload() {
      return payload_;
    }
    /**
     * <pre>
     *Generalized
     * </pre>
     *
     * <code>bytes payload = 6;</code>
     * @param value The payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayload(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      payload_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Generalized
     * </pre>
     *
     * <code>bytes payload = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearPayload() {
      
      payload_ = getDefaultInstance().getPayload();
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:route.Route)
  }

  // @@protoc_insertion_point(class_scope:route.Route)
  private static final route.Route DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new route.Route();
  }

  public static route.Route getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Route>
      PARSER = new com.google.protobuf.AbstractParser<Route>() {
    @java.lang.Override
    public Route parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Route(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Route> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Route> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public route.Route getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

