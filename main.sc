//> using lib "org.typelevel::cats-core:2.10.0"
//> using lib "org.typelevel::kittens:3.2.0"

import cats.Eq
import cats.Show
import cats.derived.*
import cats.syntax.all._

enum MyADT derives Eq {
  case A1
  case A2
  case A3
  case A4
  case A5
  case A6
  case A7
  case A8
  case A9
  case A10
  case A11
  case A12
  case A13
  case A14
  case A15
  case A16
  case A17
  // case A18
  // case A19
  // case A20
  case A21(foo: String, bar: Int, zoo: String, baz: String, bur: String)
}

println(MyADT.A2 === MyADT.A1)
