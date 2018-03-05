import akka.actor.Actor

class Reporter(value: Int) extends Actor {
  override def receive: Receive = {
    case "how much" => sender ! value
  }

}
