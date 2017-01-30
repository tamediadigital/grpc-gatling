package ch.tamedia.gatling

import ch.tamedia.gatling.grpc._
import com.trueaccord.scalapb.GeneratedMessage
import io.gatling.commons.validation.{Failure, Validation}
import io.gatling.core.check.CheckResult
import io.gatling.core.session.Session

import scala.collection.mutable

/**
  * Simple match class, checking if response message (GeneratedMessage) satisfy checker function.
  * It is possible to write more complex checkers in case they are needed.
  * @param func
  */
case class GrpcCustomCheck(func: GeneratedMessage => Boolean) extends GrpcCheck{
  override def check(response: GeneratedMessage, session: Session)(implicit cache: mutable.Map[Any, Any]): Validation[CheckResult] = {
    func(response) match {
      case true => CheckResult.NoopCheckResultSuccess
      case _ => Failure("Grpc check failed")
    }
  }
}
