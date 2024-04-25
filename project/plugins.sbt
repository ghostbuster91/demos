addSbtPlugin("com.lightbend.sbt" % "sbt-java-formatter" % "0.8.0")
addSbtPlugin("net.aichler" % "sbt-jupiter-interface" % "0.11.1")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.10.0")
addSbtPlugin(
  "com.disneystreaming.smithy4s" % "smithy4s-sbt-codegen" % "0.18.15"
)
addSbtPlugin("com.guizmaii" % "sbt-datadog" % "4.9.5")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.2.0")
addSbtPlugin("com.eed3si9n" % "sbt-projectmatrix" % "0.10.0")

addDependencyTreePlugin

// We include that dependency to override the version that sbt-java-formatter uses
// as there was no new release for a while...
libraryDependencies ++= Seq(
  "com.google.googlejavaformat" % "google-java-format" % "1.19.2"
)
