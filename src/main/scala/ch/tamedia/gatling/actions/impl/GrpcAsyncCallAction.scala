package ch.tamedia.gatling.actions.impl

import ch.tamedia.gatling.actions.GrpcExecutableAsyncAction
import ch.tamedia.noname.server.grpc.endpoint.log.LogEndpointGrpc.LogEndpointStub
import ch.tamedia.noname.server.grpc.endpoint.log.{LogEndpointGrpc, LogRequest}
import com.trueaccord.scalapb.GeneratedMessage
import io.grpc.ManagedChannelBuilder

import scala.concurrent.Future

/**
  * Async call action
  */
object GrpcAsyncCallAction {
  /**
    * Constructor that needs couple of params in order to create valid gRPC connection
    * @param name           - function name
    * @param host           - server host
    * @param port           - server port
    * @param requestMessage - message to be send as request
    * @return               - GrpcAsyncCallAction
    */
  def apply(name: String, host: String, port: Int, requestMessage: String): GrpcAsyncCallAction = new GrpcAsyncCallAction(name, host, port, requestMessage)
}

class GrpcAsyncCallAction(val name: String, host: String, port: Int, requestMessage: String) extends GrpcExecutableAsyncAction{

  var channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build
  val asyncCall: LogEndpointStub = LogEndpointGrpc.stub(channel)

  /**
    * Send async call to the server
    * @return Future[GeneratedMessage]
    */
  override def executeAsync: Future[GeneratedMessage] = asyncCall.send(new LogRequest(requestMessage))
}
