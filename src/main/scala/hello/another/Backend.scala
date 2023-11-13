package hello.another

trait Backend[F[_]] {

  def get(key: String): F[String]

}

object Backend {}
