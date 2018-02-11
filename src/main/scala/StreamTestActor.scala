import akka.NotUsed
import akka.actor.{ActorSystem, Props}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}

object StreamTestActor extends App {
  implicit val system = ActorSystem("main")
  implicit val materializer = ActorMaterializer()
  val counter = system.actorOf(Props(new Counter))

  val source: Source[Int, NotUsed] = Source.repeat(1)
  val flow: Flow[Int, Int, NotUsed] = Flow.fromFunction((x: Int) => x)
  val sink: Sink[Int, NotUsed] = Sink.actorRefWithAck(
    ref = counter,
    onInitMessage = "init",
    onCompleteMessage = "show",
    ackMessage = "ack"
  )
  source.via(flow).to(sink).run()

  Thread.sleep(10000)
  counter ! "show"
  system.terminate()
}
