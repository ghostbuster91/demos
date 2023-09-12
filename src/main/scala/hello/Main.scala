package hello

object Main {

  def main(args: Array[String]) = {
    println(new ScalaRecord(new BRecord(new SRecord("")), new Regular()))
  }
}
