package hello

import cats.effect.IO
import cats.effect.IOApp
import hello.WeatherService
import hello.Greeting
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import smithy4s.http4s.SimpleRestJsonBuilder

object Main extends IOApp.Simple {
  def run = SimpleRestJsonBuilder
    .routes(
      new WeatherService[IO] {
        def hello(): IO[Greeting] = {
          IO.pure(new Greeting("message", 404))
        }
      }
    )
    .resource
    .flatMap { routes =>
      EmberServerBuilder
        .default[IO]
        .withHttpApp(routes.orNotFound)
        .build
    }
    .flatMap { server =>
      EmberClientBuilder
        .default[IO]
        .build
        .flatMap { c =>
          SimpleRestJsonBuilder(WeatherService)
            .client(c)
            .uri(server.baseUri)
            .resource
            .evalMap {
              _.hello().flatMap(IO.println(_))
            }
        }
    }
    .use_
}
