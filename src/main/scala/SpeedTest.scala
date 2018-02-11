import akka.actor.{ActorSystem, Props}

object SpeedTest extends App {
  val system = ActorSystem("main")
  val counter = system.actorOf(Props(new Counter))

  counter ! "count"
  Thread.sleep(10000)
  counter ! "show"

  Thread.sleep(100)
  system.terminate()
}
