import akka.actor.Actor

class Counter extends Actor {
  var count: Int = 0

  def receive = {
    case "count" =>
      count += 1
      self ! "count"
    case "show" => println(s"Count = $count")
    case x: Int => count +=1; sender() ! "ack"
    case "init" => sender() ! "ack"
  }
}
