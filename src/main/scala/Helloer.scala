import akka.actor.Actor

class Helloer extends Actor {
  def receive = {
    case "say hello" => println("Hello from Actor!")
    case "say goodbye" => println("See you")
  }
}
