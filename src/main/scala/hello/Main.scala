package hello

import hello.another.Backend

object Main {
  // go to definition from here doesn't work
  private val dummyBackend = new Backend {

    def get(key: String): List[String] = List.empty
  }

  // go to definition from function argument works
  def main(args: Backend) = {}
  

}
