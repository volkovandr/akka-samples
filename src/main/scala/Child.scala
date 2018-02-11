import akka.actor.{Actor, ActorLogging, ActorRef, Props}

class Child(val level: Int) extends Actor {
  if(level % 10000 == 0) println(s"${System.currentTimeMillis()}: I'm on $level level!")
  var child: ActorRef = _

  def receive = {
    case "act" =>
      child = context.actorOf(Props(new Child(level + 1)))
      child ! "act"
  }
}
