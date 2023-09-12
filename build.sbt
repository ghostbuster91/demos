val root = project
  .in(file("."))
  .settings(
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
    ),
    scalacOptions ++= Seq(
      "-Wunused:imports"
    ),
    fork := true
  )
