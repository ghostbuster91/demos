package com.example

case class Baz() {

  def methodA(
    doSth: String => Boolean
  ): Bazzes = ???

}

case class A(foo: Bazzes)
case class B(foo: Set[Baz])

object Main {

  def here(baz: Baz) = A(
    foo = baz.methodA(_.isEmpty())
  )

  def here2(baz: Baz) = B(
    foo = baz.methodA(_.isEmpty())
  )

  def here3(baz: Baz) = A(
    baz.methodA(_.isEmpty())
  )

}
