import akka.actor.{ActorSystem, Props}
import akka.pattern.gracefulStop
import scala.concurrent.duration._

object SwitchContextTest extends App {
  val system = ActorSystem("main")
  implicit val ec = system.dispatcher
  val greeter = system.actorOf(Props[Greeter])

  for(i <- 1 to 3) {
    greeter ! "greet"
    greeter ! "goodbye"
    greeter ! "move on"
  }

  gracefulStop(greeter, 100 millis).onComplete {_ => system.terminate()}
}
