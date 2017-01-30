package ch.tamedia.gatling

import io.gatling.core.protocol.{Protocol, ProtocolKey}


object GrpcProtocol {

  val GrpcProtocolKey = new ProtocolKey {

    override type Protocol = GrpcProtocol
    override type Components = GrpcComponents

    override def protocolClass: _root_.scala.Predef.Class[_root_.io.gatling.core.protocol.Protocol] = classOf[GrpcProtocol].asInstanceOf[Class[io.gatling.core.protocol.Protocol]]

    override def defaultValue(configuration: _root_.io.gatling.core.config.GatlingConfiguration): GrpcProtocol = throw new IllegalStateException("Can't provide a default value for GrpcProtocol")

    override def newComponents(system: _root_.akka.actor.ActorSystem, coreComponents: _root_.io.gatling.core.CoreComponents): GrpcProtocol => GrpcComponents = {
      grpcProtocol => GrpcComponents(grpcProtocol)
    }
  }
}

case class GrpcProtocol() extends Protocol{
  type Components = GrpcComponents
}
