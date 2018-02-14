import akka.actor.Actor

class Greeter extends Actor {

  def morning: Receive = {
    case "greet" => println("Good morning!")
    case "goodbye" => println("seeya!")
    case "move on" => context.become(afternoon)
  }

  def afternoon: Receive = {
    case "greet" => println("Good afternoon!")
    case "goodbye" => println("Good bye!")
    case "move on" => context.become(evening)
  }

  def evening: Receive = {
    case "greet" => println("Good evening!")
    case "goodbye" => println("Good night!")
    case "move on" => context.become(morning)
  }

  override def receive: Receive = morning
}
