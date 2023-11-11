val moduleA = project
  .in(file("moduleA"))
  .settings(
    scalaVersion := "2.13.11"
  )

val moduleB = project
  .in(file("moduleB"))
  .dependsOn(moduleA)
  .settings(
    scalaVersion := "2.13.11"
  )
