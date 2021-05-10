object S12_FunctionBasic extends  App {
  // Functions called as First Class Citizen in SCALA
  // A function can be returned from another function,
  // a function can be passed as arguments to another function
  // a function can be used as reference variable/val

  // Functions are called Lambda in Java
  // define function using =>  or using FunctionN
  // function can be annonymous
  // 1 argument function as Int, return an Int
  val power = (n: Int) => n * n
  val add = (a: Int, b: Int) => a + b

  println(power(10))
  println(add(20,30))

  // a function can be used as reference variable/val
  val sum = add // assign the function reference to sum
  // def higherOrderFunction(add:)
  // def curryFunction(): return add, a function that returns another function
}
