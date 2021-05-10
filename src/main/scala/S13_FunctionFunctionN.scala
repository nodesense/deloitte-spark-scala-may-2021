object S13_FunctionFunctionN extends  App {
  // Scala FunctionN , refers to Function0,...Function22

  // In scala, all functions defined using => fat arrow are syntatic sugar
  // compiter will transpile => fat arrow function to FunctionM, Function0, ...Function1..

  // Input: Int
      // 1 arg: Function1
  // Output: Int
  val power = (n: Int) => n * n
  // the type of power function is on FunctionN
  // FunctionN[All Inputs arg types, At last the output/return Type]
  // [Generic/Any Type]
  // [Int/input, Int/return]
  val powerAs: Function1[Int, Int] = power

  // both power and powerAs


  // Input: Int, Int
    // 2 args: Function2
  // Output: Int
  val add = (a: Int, b: Int) => a + b
  // [a/Int, b: Int, return value/Int]
  val addAs: Function2[Int, Int, Int] = add;

  // Input: String
    // 1 argument: Function 1
  // Output: Unit
  val greeting = (msg: String) => println(msg)
  val greetingAs: Function1[String, Unit] = greeting;
  // Input: none
    // 0 arg: Function0
  // Output: Unit
  val show = () => println("Scala")
  // [Return Type] since no arguments
  val showAs: Function0[Unit] = show

  println(add(10, 20))
  println(addAs(10, 20))

  println(power(5))
  println(powerAs(5))
  greeting("GM")
  greetingAs("GM")
  show()
  showAs()

}
