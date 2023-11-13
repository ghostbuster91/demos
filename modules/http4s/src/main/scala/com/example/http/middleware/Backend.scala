package com.example.http.middleware

trait Backend[F[_]] {
  def get(key: String): F[Response]
}


final case class Response(attributes: Map[String, String])
