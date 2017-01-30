package ch.tamedia.noname.server.grpc.endpoint.log

object LogEndpointGrpc {
  val METHOD_SEND: _root_.io.grpc.MethodDescriptor[LogRequest, LogResponse] =
    _root_.io.grpc.MethodDescriptor.create(
      _root_.io.grpc.MethodDescriptor.MethodType.UNARY,
      _root_.io.grpc.MethodDescriptor.generateFullMethodName("ch.tamedia.noname.server.grpc.endpoint.log.LogEndpoint", "send"),
      new com.trueaccord.scalapb.grpc.Marshaller(LogRequest),
      new com.trueaccord.scalapb.grpc.Marshaller(LogResponse))

  trait LogEndpoint extends _root_.com.trueaccord.scalapb.grpc.AbstractService {
    override def serviceCompanion = LogEndpoint
    def send(request: LogRequest): scala.concurrent.Future[LogResponse]
  }

  object LogEndpoint extends _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[LogEndpoint] {
    implicit def serviceCompanion: _root_.com.trueaccord.scalapb.grpc.ServiceCompanion[LogEndpoint] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = LogProto.javaDescriptor.getServices().get(0)
  }

  trait LogEndpointBlockingClient {
    def serviceCompanion = LogEndpoint
    def send(request: LogRequest): LogResponse
  }

  class LogEndpointBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogEndpointBlockingStub](channel, options) with LogEndpointBlockingClient {
    override def send(request: LogRequest): LogResponse = {
      _root_.io.grpc.stub.ClientCalls.blockingUnaryCall(channel.newCall(METHOD_SEND, options), request)
    }

    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogEndpointBlockingStub = new LogEndpointBlockingStub(channel, options)
  }

  class LogEndpointStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[LogEndpointStub](channel, options) with LogEndpoint {
    override def send(request: LogRequest): scala.concurrent.Future[LogResponse] = {
      com.trueaccord.scalapb.grpc.Grpc.guavaFuture2ScalaFuture(_root_.io.grpc.stub.ClientCalls.futureUnaryCall(channel.newCall(METHOD_SEND, options), request))
    }

    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): LogEndpointStub = new LogEndpointStub(channel, options)
  }

  def bindService(serviceImpl: LogEndpoint, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
    _root_.io.grpc.ServerServiceDefinition.builder("ch.tamedia.noname.server.grpc.endpoint.log.LogEndpoint")
      .addMethod(
        METHOD_SEND,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[LogRequest, LogResponse] {
          override def invoke(request: LogRequest, observer: _root_.io.grpc.stub.StreamObserver[LogResponse]): Unit =
            serviceImpl.send(request).onComplete(com.trueaccord.scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .build()

  def blockingStub(channel: _root_.io.grpc.Channel): LogEndpointBlockingStub = new LogEndpointBlockingStub(channel)

  def stub(channel: _root_.io.grpc.Channel): LogEndpointStub = new LogEndpointStub(channel)

  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = LogProto.javaDescriptor.getServices().get(0)

}