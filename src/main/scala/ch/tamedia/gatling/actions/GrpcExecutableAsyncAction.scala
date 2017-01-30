package ch.tamedia.gatling.actions

import com.trueaccord.scalapb.GeneratedMessage

import scala.concurrent.Future


/**
  * Implementation of GrpcExecutableAction that disables Sync call
  */
trait GrpcExecutableAsyncAction extends GrpcExecutableAction{
  final override def executeSync: Option[GeneratedMessage] = throw new UnsupportedOperationException("Sync calls are not supported in async actions")
}
