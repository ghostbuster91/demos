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
    // doesn't work here
    foo = baz.methodA(_.isEmpty())
  )

  def here2(baz: Baz) = B(
    // works here
    foo = baz.methodA(_.isEmpty())
  )

  def here3(baz: Baz) = A(
    // works here
    baz.methodA(_.isEmpty())
  )

}
