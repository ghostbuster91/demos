package com.example

sealed trait Types {}

object Types {
  case class Product(id: String) extends Types
}
