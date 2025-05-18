package com.example

import mill.testkit.TestBaseModule
import mill.testkit.UnitTester
import mill.scalalib._
import mill._
// import sourcecode.FullName
import java.nio.file.Paths
// import mill.scalalib.publish.PomSettings
// import mill.scalalib.publish.VersionControl
// import coursier.Repository
// import coursier.ivy.IvyRepository
// import mill.define.Task

import scala.annotation.nowarn

import java.io.IOException
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.stream.Collectors
import scala.jdk.CollectionConverters._

class HelloTests extends munit.FunSuite {

  test("test1") {

    val tempDir = Files.createTempDirectory("mydir")
    copyResourceDir("multi-module", tempDir)

    val resourcePath: os.Path = os.Path(tempDir)

    object foo extends TestBaseModule with ScalaModule {
      override def scalaVersion = "2.13.16"
      override def ivyDeps = Agg(
        ivy"com.disneystreaming.smithy4s::smithy4s-aws-kernel:0.18.35"
      )

    }

    object bar extends TestBaseModule with ScalaModule {
      override def scalaVersion = "2.13.16"
      override def moduleDeps = Seq(foo)
    }

    val fooResource = resourcePath / "foo"
    UnitTester(foo, fooResource).scoped { fooEval =>
      val fooCompile = fooEval(foo.compile)
      println(fooCompile)
      assertEquals(
        fooCompile.isRight,
        true,
      )

    }

    val barResource = resourcePath / "bar"
    UnitTester(bar, barResource).scoped { barEval =>
      val barCompile = barEval(bar.compile)
      println(barCompile)
      assertEquals(
        barCompile.isRight,
        true,
      )
    }
  }

  def copyResourceDir(resourceDir: String, targetDir: Path): Unit = {
    val dirURL = getClass.getClassLoader.getResource(resourceDir)
    if (dirURL == null) {
      throw new IllegalArgumentException(s"Resource $resourceDir not found")
    }

    if (dirURL.getProtocol == "jar") {
      val uri = dirURL.toURI
      val fs = FileSystems.newFileSystem(uri, Map.empty[String, Any].asJava)
      val jarPath = fs.getPath(resourceDir)
      Files.walk(jarPath).forEach { path =>
        if (Files.isRegularFile(path)) {
          val rel = jarPath.relativize(path)
          val dest = targetDir.resolve(rel.toString)
          Files.createDirectories(dest.getParent)
          Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING)
        }
      }
    } else if (dirURL.getProtocol == "file") {
      val srcDir = Paths.get(dirURL.toURI)
      Files.walk(srcDir).forEach { path =>
        if (Files.isRegularFile(path)) {
          val rel = srcDir.relativize(path)
          val dest = targetDir.resolve(rel.toString)
          Files.createDirectories(dest.getParent)
          Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING)
        }
      }
    } else {
      throw new UnsupportedOperationException(s"Unsupported protocol: ${dirURL.getProtocol}")
    }
  }

}
