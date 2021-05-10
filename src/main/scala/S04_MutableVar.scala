object S04_MutableVar extends  App {
  // Variable, mutabel, change the value anytime
  var version = "2.11"; // type inference, type is string
  var lang: String = "Scala"

  println(version, lang)
  version = "2.12"
  println(version, lang)

  var i : Int = 0;
  println(i)
  i += 1
  println(i)

}
