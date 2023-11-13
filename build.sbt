val scala3Version   = "3.3.0"
val scala213Version = "2.13.11"

inThisBuild(
  Seq(
    organization := "com.example.http",
    scalaVersion := scala213Version,
  )
)

lazy val root = project
  .aggregate(http4s)
  .in(file("."))

lazy val http4s = project
  .in(file("modules/http4s"))
