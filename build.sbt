val moduleA = project
  .in(file("moduleA"))
  .settings(
    scalaVersion := "3.3.3"
  )

val moduleB = project
  .in(file("moduleB"))
  .settings(
    scalaVersion := "3.3.3",
    scalacOptions ++= Seq(
      "-Xfatal-warnings"
    ),
    javacOptions ++= Seq(
      "-Xlint:unchecked"
    )
  )

val root = project.in(file(".")).aggregate(moduleA, moduleB)
