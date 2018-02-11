name := "akka-samples"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.9" % Test
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.9"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"   % "10.1.0-RC1",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.0-RC1"
)
