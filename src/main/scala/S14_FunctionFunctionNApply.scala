object S14_FunctionFunctionNApply extends  App {

  // function is an object, Function0, Function1...FunctionN are basically classes
  val power = (n:Int) => n * n  // sugar, internally it writes Function1 with apply code

  // the above code is converted to below format by scala
  val powerAs = new Function1[Int, Int] {
     def apply(n: Int): Int = n * n
  }

  // calling a function like power(10) is converted to power.apply(10) by scala
  println(power(10)) // 100
  println(power.apply(10)) // 100

  println(powerAs(10)) // 100
  println(powerAs.apply(10)) // 100
}
