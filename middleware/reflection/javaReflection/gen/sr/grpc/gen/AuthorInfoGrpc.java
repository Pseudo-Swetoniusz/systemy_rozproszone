package sr.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: proto/author.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthorInfoGrpc {

  private AuthorInfoGrpc() {}

  public static final String SERVICE_NAME = "author.AuthorInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.nameRequest,
      sr.grpc.gen.Author> getGetAuthorByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAuthorByName",
      requestType = sr.grpc.gen.nameRequest.class,
      responseType = sr.grpc.gen.Author.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.nameRequest,
      sr.grpc.gen.Author> getGetAuthorByNameMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.nameRequest, sr.grpc.gen.Author> getGetAuthorByNameMethod;
    if ((getGetAuthorByNameMethod = AuthorInfoGrpc.getGetAuthorByNameMethod) == null) {
      synchronized (AuthorInfoGrpc.class) {
        if ((getGetAuthorByNameMethod = AuthorInfoGrpc.getGetAuthorByNameMethod) == null) {
          AuthorInfoGrpc.getGetAuthorByNameMethod = getGetAuthorByNameMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.nameRequest, sr.grpc.gen.Author>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAuthorByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.nameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Author.getDefaultInstance()))
              .setSchemaDescriptor(new AuthorInfoMethodDescriptorSupplier("getAuthorByName"))
              .build();
        }
      }
    }
    return getGetAuthorByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest,
      sr.grpc.gen.Authors> getGetAuthorsByNationalityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAuthorsByNationality",
      requestType = sr.grpc.gen.nationalityRequest.class,
      responseType = sr.grpc.gen.Authors.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest,
      sr.grpc.gen.Authors> getGetAuthorsByNationalityMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest, sr.grpc.gen.Authors> getGetAuthorsByNationalityMethod;
    if ((getGetAuthorsByNationalityMethod = AuthorInfoGrpc.getGetAuthorsByNationalityMethod) == null) {
      synchronized (AuthorInfoGrpc.class) {
        if ((getGetAuthorsByNationalityMethod = AuthorInfoGrpc.getGetAuthorsByNationalityMethod) == null) {
          AuthorInfoGrpc.getGetAuthorsByNationalityMethod = getGetAuthorsByNationalityMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.nationalityRequest, sr.grpc.gen.Authors>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAuthorsByNationality"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.nationalityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Authors.getDefaultInstance()))
              .setSchemaDescriptor(new AuthorInfoMethodDescriptorSupplier("getAuthorsByNationality"))
              .build();
        }
      }
    }
    return getGetAuthorsByNationalityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest,
      sr.grpc.gen.Count> getCountByNationalityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "countByNationality",
      requestType = sr.grpc.gen.nationalityRequest.class,
      responseType = sr.grpc.gen.Count.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest,
      sr.grpc.gen.Count> getCountByNationalityMethod() {
    io.grpc.MethodDescriptor<sr.grpc.gen.nationalityRequest, sr.grpc.gen.Count> getCountByNationalityMethod;
    if ((getCountByNationalityMethod = AuthorInfoGrpc.getCountByNationalityMethod) == null) {
      synchronized (AuthorInfoGrpc.class) {
        if ((getCountByNationalityMethod = AuthorInfoGrpc.getCountByNationalityMethod) == null) {
          AuthorInfoGrpc.getCountByNationalityMethod = getCountByNationalityMethod =
              io.grpc.MethodDescriptor.<sr.grpc.gen.nationalityRequest, sr.grpc.gen.Count>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "countByNationality"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.nationalityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.gen.Count.getDefaultInstance()))
              .setSchemaDescriptor(new AuthorInfoMethodDescriptorSupplier("countByNationality"))
              .build();
        }
      }
    }
    return getCountByNationalityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthorInfoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorInfoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorInfoStub>() {
        @java.lang.Override
        public AuthorInfoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorInfoStub(channel, callOptions);
        }
      };
    return AuthorInfoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthorInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorInfoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorInfoBlockingStub>() {
        @java.lang.Override
        public AuthorInfoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorInfoBlockingStub(channel, callOptions);
        }
      };
    return AuthorInfoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthorInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorInfoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorInfoFutureStub>() {
        @java.lang.Override
        public AuthorInfoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorInfoFutureStub(channel, callOptions);
        }
      };
    return AuthorInfoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AuthorInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAuthorByName(sr.grpc.gen.nameRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Author> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthorByNameMethod(), responseObserver);
    }

    /**
     */
    public void getAuthorsByNationality(sr.grpc.gen.nationalityRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Authors> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthorsByNationalityMethod(), responseObserver);
    }

    /**
     */
    public void countByNationality(sr.grpc.gen.nationalityRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Count> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCountByNationalityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAuthorByNameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sr.grpc.gen.nameRequest,
                sr.grpc.gen.Author>(
                  this, METHODID_GET_AUTHOR_BY_NAME)))
          .addMethod(
            getGetAuthorsByNationalityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sr.grpc.gen.nationalityRequest,
                sr.grpc.gen.Authors>(
                  this, METHODID_GET_AUTHORS_BY_NATIONALITY)))
          .addMethod(
            getCountByNationalityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sr.grpc.gen.nationalityRequest,
                sr.grpc.gen.Count>(
                  this, METHODID_COUNT_BY_NATIONALITY)))
          .build();
    }
  }

  /**
   */
  public static final class AuthorInfoStub extends io.grpc.stub.AbstractAsyncStub<AuthorInfoStub> {
    private AuthorInfoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorInfoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorInfoStub(channel, callOptions);
    }

    /**
     */
    public void getAuthorByName(sr.grpc.gen.nameRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Author> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAuthorsByNationality(sr.grpc.gen.nationalityRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Authors> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorsByNationalityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void countByNationality(sr.grpc.gen.nationalityRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.gen.Count> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCountByNationalityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthorInfoBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuthorInfoBlockingStub> {
    private AuthorInfoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorInfoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public sr.grpc.gen.Author getAuthorByName(sr.grpc.gen.nameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.Authors getAuthorsByNationality(sr.grpc.gen.nationalityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorsByNationalityMethod(), getCallOptions(), request);
    }

    /**
     */
    public sr.grpc.gen.Count countByNationality(sr.grpc.gen.nationalityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCountByNationalityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthorInfoFutureStub extends io.grpc.stub.AbstractFutureStub<AuthorInfoFutureStub> {
    private AuthorInfoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorInfoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Author> getAuthorByName(
        sr.grpc.gen.nameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Authors> getAuthorsByNationality(
        sr.grpc.gen.nationalityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorsByNationalityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sr.grpc.gen.Count> countByNationality(
        sr.grpc.gen.nationalityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCountByNationalityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTHOR_BY_NAME = 0;
  private static final int METHODID_GET_AUTHORS_BY_NATIONALITY = 1;
  private static final int METHODID_COUNT_BY_NATIONALITY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthorInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthorInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AUTHOR_BY_NAME:
          serviceImpl.getAuthorByName((sr.grpc.gen.nameRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Author>) responseObserver);
          break;
        case METHODID_GET_AUTHORS_BY_NATIONALITY:
          serviceImpl.getAuthorsByNationality((sr.grpc.gen.nationalityRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Authors>) responseObserver);
          break;
        case METHODID_COUNT_BY_NATIONALITY:
          serviceImpl.countByNationality((sr.grpc.gen.nationalityRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.gen.Count>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuthorInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthorInfoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.gen.AuthorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthorInfo");
    }
  }

  private static final class AuthorInfoFileDescriptorSupplier
      extends AuthorInfoBaseDescriptorSupplier {
    AuthorInfoFileDescriptorSupplier() {}
  }

  private static final class AuthorInfoMethodDescriptorSupplier
      extends AuthorInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthorInfoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthorInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthorInfoFileDescriptorSupplier())
              .addMethod(getGetAuthorByNameMethod())
              .addMethod(getGetAuthorsByNationalityMethod())
              .addMethod(getCountByNationalityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
