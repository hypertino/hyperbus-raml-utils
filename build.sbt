crossScalaVersions := Seq("2.12.3", "2.11.11", "2.10.6")

scalaVersion := crossScalaVersions.value.head

organization := "com.hypertino"

name := "hyperbus-utils"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % "test"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)
