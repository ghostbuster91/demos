import mill._

def assembly(foo:String, bar: String) = T.command {
    println(s"foo '$foo' bar '$bar'")
}
