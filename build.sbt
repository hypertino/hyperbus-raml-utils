crossScalaVersions := Seq("2.12.4", "2.11.12")

scalaVersion := crossScalaVersions.value.head

organization := "com.hypertino"

name := "hyperbus-utils"

version := "0.2.0"

libraryDependencies ++= Seq(
  "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % "test"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public")
)
