val moduleB = project
  .in(file("moduleB"))
  .settings(
    scalaVersion := "3.3.3"
  )

val root = project.in(file(".")).aggregate(moduleB)
