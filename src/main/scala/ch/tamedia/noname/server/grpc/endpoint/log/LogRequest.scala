// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package ch.tamedia.noname.server.grpc.endpoint.log

/** The request message containing the log payload
  */
@SerialVersionUID(0L)
final case class LogRequest(
                             payload: String = ""
                           ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[LogRequest] with com.trueaccord.lenses.Updatable[LogRequest] {
  @transient
  private[this] var __serializedSizeCachedValue: Int = 0
  private[this] def __computeSerializedValue(): Int = {
    var __size = 0
    if (payload != "") { __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, payload) }
    __size
  }
  final override def serializedSize: Int = {
    var read = __serializedSizeCachedValue
    if (read == 0) {
      read = __computeSerializedValue()
      __serializedSizeCachedValue = read
    }
    read
  }
  def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): Unit = {
    {
      val __v = payload
      if (__v != "") {
        _output__.writeString(1, __v)
      }
    };
  }
  def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): LogRequest = {
    var __payload = this.payload
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __payload = _input__.readString()
        case tag => _input__.skipField(tag)
      }
    }
    LogRequest(
      payload = __payload
    )
  }
  def withPayload(__v: String): LogRequest = copy(payload = __v)
  def getField(__field: _root_.com.google.protobuf.Descriptors.FieldDescriptor): scala.Any = {
    __field.getNumber match {
      case 1 => {
        val __t = payload
        if (__t != "") __t else null
      }
    }
  }
  override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToSingleLineUnicodeString(this)
  def companion = LogRequest
}

object LogRequest extends com.trueaccord.scalapb.GeneratedMessageCompanion[LogRequest] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[LogRequest] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): LogRequest = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    LogRequest(
      __fieldsMap.getOrElse(__fields.get(0), "").asInstanceOf[String]
    )
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = LogProto.javaDescriptor.getMessageTypes.get(0)
  def messageCompanionForField(__field: _root_.com.google.protobuf.Descriptors.FieldDescriptor): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__field)
  def enumCompanionForField(__field: _root_.com.google.protobuf.Descriptors.FieldDescriptor): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__field)
  lazy val defaultInstance = LogRequest(
  )
  implicit class LogRequestLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, LogRequest]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, LogRequest](_l) {
    def payload: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.payload)((c_, f_) => c_.copy(payload = f_))
  }
  final val PAYLOAD_FIELD_NUMBER = 1
}
