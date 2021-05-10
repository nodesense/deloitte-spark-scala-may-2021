object S15_MethodVsFunction extends  App {
  def power(n: Int) = n * n
  val pow = (n: Int) => n * n

  // def is a method, pow is a variable/value that referenc to a function1 instnace
  // methods are member functions of class or object in Java/Scala
  // functions are lambdas similar to java which are object

  //power(10) // works
  //power.apply(10) // doesn't works
  //val k = power ; // doesn't work, power is not an object/Function

  pow.apply(10) // works
  pow(10) // works
  val p2 = pow // works

  // you can a wrapper function for method in scala in very easy way using _ underscore
  // val k = power // doesn't work
  // scala compiler automatically create a Function1, wrap the original power method
  val powerAs = power _  // works, scala compiler build a wrapper function1
  println(powerAs.apply(10))
  println(powerAs(10))
  // convert a method into function
  println( (power _) (10)) // works

  val add = (a: Int, b: Int) => {
    println(a, b)
    a + b // this value returned
  }

  println(add(10, 20))
}
