import akka.actor.Actor

class Ponger extends Actor {
  def receive = {
    case "ping" => sender() ! "pong"
  }
}
