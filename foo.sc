//> using scala 2.13
//> using dep "io.get-coursier::coursier:2.1.8"

import coursier.core.Authentication
import coursier.maven.MavenRepository
import coursier.parse.DependencyParser

val repositories: List[MavenRepository] = List(
  MavenRepository("https://repo1.maven.org/maven2"),
  MavenRepository(s"file:/root/.m2/repository/"),
)

val dependencies = List("com.fasterxml.jackson.core:jackson-core:2.16.1")

val result =
  for {
    deps <-
      DependencyParser
        .dependencies(dependencies, "3.0.0")
        .either
  } yield coursier
    .Fetch()
    .addRepositories(repositories: _*)
    .addDependencies(deps: _*)
    .run()

println(result)
