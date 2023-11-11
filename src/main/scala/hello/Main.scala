package hello

import hello.another.Backend

object Main {
  private val dummyBackend = new Backend {

    def get(key: String): List[String] = List.empty
  }

  def main(args: Backend) = {}

}
