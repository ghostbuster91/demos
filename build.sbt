val root = project
  .in(file("."))
  .settings(
    scalaVersion := "3.3.3",
    (Compile / unmanagedJars) ++= {
      Seq(
        s"${sys.env("HOME")}/.cache/coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-core_3/2.12.0/cats-core_3-2.12.0.jar",
        s"${sys.env("HOME")}/.cache/coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_3/2.12.0/cats-kernel_3-2.12.0.jar",
        s"${sys.env("HOME")}/.cache/coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-core_3/2.12.0/cats-core_3-2.12.0-sources.jar",
        s"${sys.env("HOME")}/.cache/coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_3/2.12.0/cats-kernel_3-2.12.0-sources.jar"
      ).map(file(_))
    }
  )
