package smithy4sdemo

import cats.effect.IO
import cats.effect.IOApp
import cats.effect.Resource
import hello.CityId
import hello.CreateCityOutput
import hello.GetWeatherOutput
import hello.WeatherService
import hello.Weather
import hello.MyError
import org.http4s.HttpRoutes
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import smithy4s.http4s.SimpleRestJsonBuilder
// import hello.HeadWeatherOutput

object ServerMain extends IOApp.Simple {

  val impl: WeatherService[IO] =
    new WeatherService[IO] {

      def getWeather(
        cityId: CityId
      ): IO[GetWeatherOutput] =
        IO.println(s"getWeather($cityId)") *>
          IO.raiseError(MyError("boom"))

      def createCity(
        city: String,
        country: String,
      ): IO[CreateCityOutput] =
        IO.println(s"createCity($city, $country)") *>
          IO.pure(CreateCityOutput(CityId("123")))

      def headWeather(cityId: CityId) : IO[Unit] = IO.raiseError(MyError("boom"))
    }

  def run: IO[Unit] =
    SimpleRestJsonBuilder
      .routes(impl)
      .resource
      .flatMap { routes =>
        EmberServerBuilder
          .default[IO]
          .withHttpApp(routes.orNotFound)
          .build
      }
      .evalMap(srv => IO.println(srv.addressIp4s))
      .useForever

}

object ClientMain extends IOApp.Simple {

  def run: IO[Unit] = EmberClientBuilder.default[IO].build.use { c =>
    SimpleRestJsonBuilder(WeatherService).client(c).resource.use { client =>
      client
        .headWeather(CityId("a"))
        .flatMap(IO.println(_))
        .handleErrorWith (IO.println(_))
    }
  }

}
