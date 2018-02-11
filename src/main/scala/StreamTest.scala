import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, Sink, Source}

object StreamTest extends App{
  implicit val system = ActorSystem("main")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val count: Int = 10000000

  val source = Source(1 to count)
  val sink = Sink.last[Int]

  val start = System.currentTimeMillis()

  source.toMat(sink)(Keep.right).run().onComplete(x => {
    val end = System.currentTimeMillis()
    println(s"Result is $x. It took ${end - start} milliseconds, ${count / (end - start) * 1000} per second")
    system.terminate()
  })
}
