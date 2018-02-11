import akka.actor.{ActorSystem, Props}

object Entrypoint extends App {
  val system = ActorSystem("main")
  val helloer = system.actorOf(Props(new Helloer))

  println("start")
  helloer ! "say hello"
  helloer ! "say goodbye"
  println("stop")
  Thread.sleep(100)
  system.terminate()
}
