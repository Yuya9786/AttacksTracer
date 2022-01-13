name := "malware-simulator-kai"

version := "1.0"

scalaVersion := "2.13.1"

Compile / scalacOptions ++= Seq(
  "-target:11",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlog-reflective-calls",
  "-Xlint"
)
Compile / javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

val AkkaVersion = "2.6.13"
val AkkaHttpVersion = "10.2.3"
val AkkaManagementVersion = "1.0.9"
val AkkaPersistenceJdbcVersion = "5.0.0"
val AlpakkaKafkaVersion = "2.0.6"
val AkkaProjectionVersion = "1.1.0"
val ScalikeJdbcVersion = "3.5.0"

enablePlugins(AkkaGrpcPlugin)
enablePlugins(JavaAppPackaging)


// Dockerfileに書く内容
packageName in Docker := "sample-webapp"
version in Docker := "1.0"
dockerRepository := Some("petitviolet")
maintainer in Docker := "petitviolet <mail@example.com>"
dockerExposedPorts := List(8080)
dockerBaseImage := "openjdk:latest"
dockerCmd := Nil

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scalatest" %% "scalatest" % "3.1.2" % Test,
  "com.typesafe.akka" %% "akka-http2-support" % AkkaHttpVersion,
  "org.postgresql" % "postgresql" % "42.2.19",
  "org.json4s" %% "json4s-jackson" % "3.6.12",
)
