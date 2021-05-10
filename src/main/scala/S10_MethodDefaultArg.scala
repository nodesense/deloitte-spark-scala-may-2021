object S10_MethodDefaultArg extends  App {
  // if a and/or b are not passed, the default values are taken implicitly by compiler
  def sum(a: Int = 0, b: Int = 0) = a + b

  println(sum()) // a = 0, b= 10
  println(sum(10)) // a = 10, b = 0
  println(sum(10, 20)) // a = 10, b = 20

  // Named arguments, we can pass the values with name instead of strict left to right values

  println(sum( a = 100, b = 200  )) // a = 100, b = 200
  println(sum (b = 200, a = 100)) // a = 100, b = 200

}
