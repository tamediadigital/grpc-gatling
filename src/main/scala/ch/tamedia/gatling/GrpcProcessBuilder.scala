package ch.tamedia.gatling


import ch.tamedia.gatling.actions.GrpcExecutableAction
import ch.tamedia.gatling.grpc._
import io.gatling.core.action.builder.ActionBuilder


case class GrpcProcessBuilder(action: GrpcExecutableAction, checks: List[GrpcCheck] = Nil) extends GrpcCheckSupport{
//   def payload(payload: String) = copy(payload = Some(payload))

  def check(grpcCheck: GrpcCheck*) = copy(checks = checks ::: grpcCheck.toList)

  def build(): ActionBuilder = new GrpcActionBuilder(action, checks)
}