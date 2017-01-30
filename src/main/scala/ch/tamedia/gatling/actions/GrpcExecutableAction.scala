package ch.tamedia.gatling.actions

import com.trueaccord.scalapb.GeneratedMessage

import scala.concurrent.Future

/**
  * Base trait which provide two type of calls sync and async one. It require to have name set.
  * Can be implemented as abstract class too.
  * In current version of code it has two implementations in GrpcExecutableAsyncAction and GrpcExecutableSyncAction
  */
trait GrpcExecutableAction {
  require(name.nonEmpty)
  def name: String
  def executeSync: Option[GeneratedMessage]
  def executeAsync: Future[GeneratedMessage]
}
