import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class PongerSpec() extends TestKit(ActorSystem("test")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll(): Unit = TestKit.shutdownActorSystem(system)

  "A Ponger actor" must {
    "respond with 'pong' when receives 'ping'" in {
      val ponger = system.actorOf(Props(new Ponger))
      ponger ! "ping"
      expectMsg("pong")
    }
  }

}
