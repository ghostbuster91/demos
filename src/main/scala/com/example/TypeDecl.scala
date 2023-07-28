package com.example

enum TypeDecl {

  case Product(id: String)
  case Coproduct(id: String)
}


def calling(prd: TypeDecl.Product) = ???
