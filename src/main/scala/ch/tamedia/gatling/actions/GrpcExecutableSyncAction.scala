package ch.tamedia.gatling.actions
import com.trueaccord.scalapb.GeneratedMessage

import scala.concurrent.Future

/**
  * Implementation of GrpcExecutableAction that disables Async call
  */
trait GrpcExecutableSyncAction extends GrpcExecutableAction{
  final override def executeAsync: Future[GeneratedMessage] = throw new UnsupportedOperationException("Async calls are not supported in sync actions")
}
