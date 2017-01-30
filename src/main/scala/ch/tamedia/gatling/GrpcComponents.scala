package ch.tamedia.gatling

import io.gatling.core.protocol.ProtocolComponents
import io.gatling.core.session.Session

case class GrpcComponents(grpcProtocol: GrpcProtocol) extends ProtocolComponents{
  override def onStart: Option[(Session) => Session] = None

  override def onExit: Option[(Session) => Unit] = None
}
