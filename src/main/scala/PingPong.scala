import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

object PingPong extends App {

  class Pinger extends Actor with ActorLogging {
    override def receive: Receive = {
      case "pong" =>
        log.info(s"Received 'pong' from ${sender().path}")
        Thread.sleep(1000)
        sender() ! "ping"
      case WelcomePongerAndStartGame(pongerActor) => pongerActor ! "ping"
    }
  }

  class Ponger extends Actor with ActorLogging {
    override def receive: Receive = {
      case "ping" =>
        log.info(s"Received 'ping' from ${sender().path}")
        Thread.sleep(1000)
        sender() ! "pong"
    }
  }

  case class WelcomePongerAndStartGame(ponger: ActorRef)

  val system = ActorSystem("main")
  val pinger = system.actorOf(Props[Pinger], "pinger")
  val ponger = system.actorOf(Props[Ponger], "ponger")

  pinger ! WelcomePongerAndStartGame(ponger)

  sys.addShutdownHook(system.terminate())

}
