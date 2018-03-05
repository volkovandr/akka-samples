import akka.actor.{ActorSystem, Props}
import akka.pattern.ask

import scala.concurrent.duration._
import scala.util.Success

object AskTest extends App {
  val system = ActorSystem("main")
  val reporter = system.actorOf(Props(new Reporter(5)))
  implicit val timeout: akka.util.Timeout = 5 seconds
  implicit val ec = system.dispatcher

  val answer = (reporter ? "how much").mapTo[Int]
  answer.onComplete({
    case Success(reply) =>
      println(s"The reporter replied with $reply")
      system.terminate()
  })
  println("We are done here.")
}
