scalaVersion := "2.10.6"

crossScalaVersions := Seq("2.12.1", "2.11.8", "2.10.6")

organization := "com.hypertino"

name := "hyperbus-raml-utils"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.hypertino" %% "scalamock-scalatest-support" % "3.4-SNAPSHOT" % "test"  
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)
