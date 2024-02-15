This repository showcases a problem with having `~/.m2/repository` added to coursier repositories.

If you run following steps coursier will incorrectly return empty list of resolved artifacts for jackson-core.

`docker build -t . repro`

`docker run -v ./:/src --rm -it repro`

`mvn compile`

`scala-cli foo.sc`

The reason for that is that maven will first download only poms to create a dependency tree. 
Then versions will be chosen based on maven's version conflict resolution strategy and only then maven will download jars for the picked versions. 

This will confuse coursier because it will see the directory for jackson-core with only the pom inside. 
