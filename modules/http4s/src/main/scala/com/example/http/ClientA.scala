package com.example.http

import com.example.http.middleware.Response
import com.example.http.middleware.Backend

object ClientA {

  private val dummy = new Backend[List] {
    def get(key: String): List[Response] = List(Response(Map()))
  }

}
