package ch.tamedia.gatling

import io.gatling.core.action.builder.ActionBuilder

/**
  * Implicits for protocol and action builder
  */
trait GrpcDsl extends GrpcCheckSupport{

  val GRPC = GrpcProtocolBuilder

  def grpcCall = GrpcProcessBuilder

  implicit def grpcProtocolBuilder2grpcProtocol(builder: GrpcProtocolBuilder): GrpcProtocol = builder.build()
  implicit def grpcProcessBuilder2ActionBuilder(builder: GrpcProcessBuilder): ActionBuilder = builder.build()

}
