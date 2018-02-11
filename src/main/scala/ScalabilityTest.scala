import akka.actor.{ActorSystem, Props}

object ScalabilityTest extends App {
  val system = ActorSystem("main")
  val child = system.actorOf(Props(new Child(1)))

  child ! "act"

  sys.addShutdownHook {system.terminate()}
}
