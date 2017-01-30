package ch.tamedia.gatling.actions.impl

import ch.tamedia.gatling.actions.GrpcExecutableSyncAction
import ch.tamedia.noname.server.grpc.endpoint.log.{LogEndpointGrpc, LogRequest}
import io.grpc.ManagedChannelBuilder

/**
  * Sync call action
  */
object GrpcSyncCallAction {
  /**
    *
    * Constructor that needs couple of params in order to create valid gRPC connection
    * @param name           - function name
    * @param host           - server host
    * @param port           - server port
    * @param requestMessage - message to be send as request
    * @return               - GrpcSyncCallAction
    */
  def apply(name: String, host: String, port: Int, requestMessage: String): GrpcSyncCallAction = new GrpcSyncCallAction(name, host, port, requestMessage)
}

class GrpcSyncCallAction(val name: String, host: String, port: Int, requestMessage: String) extends GrpcExecutableSyncAction {

  var channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build
  val blockingCall = LogEndpointGrpc.blockingStub(channel)

  /**
    * Create sync call to the server
    * @return Option[GeneratedMessage]
    */
  override def executeSync = Some(blockingCall.send(new LogRequest(requestMessage)))
}
