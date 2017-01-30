package ch.tamedia.gatling

import com.trueaccord.scalapb.GeneratedMessage
import io.gatling.commons.validation.Success
import io.gatling.core.check.{Check, Extender, Preparer}

object grpc {
  type GrpcCheck = Check[GeneratedMessage]

  val GrpcStringExtender: Extender[GrpcCheck, GeneratedMessage] = (check: GrpcCheck) => check

  val GrpcStringPreparer: Preparer[String, String] = (result: String) => Success(result)
}
