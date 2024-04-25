package hello

case class Person(name: String)

object Person{
  def fromList(list: List[Any])={
    Person(name = list(0).asInstanceOf[String])
  }
}
