lazy val cats = Seq(
  "org.typelevel" %% "cats-core" % "2.9.0",
  "org.typelevel" %% "kittens" % "3.0.0",
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-example-project",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalaVersion := "2.13.11",
    scalacOptions ++= Seq("-deprecation"),
    libraryDependencies ++= cats,
  )
