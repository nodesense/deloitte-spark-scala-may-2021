object S16_IfExpr extends  App {
  //In Scala, If is an expression that returns a value
  val result = if (10 > 5) "GreaterThan"
  println(result)
  val result2 = if (10 < 5) "GreaterThan" else "LessThan"
  println(result2)

  // write a method that returns "Even" or "Odd"
  def oddOrEven(n: Int) = if (n % 2 == 0) "Even" else "Odd"

  def oddOrEven2(n: Int) = {
    // if is an expression
    // here, we get either Even or Odd from if expression
    // In Scala, last evaluated expression is returned. this code returns Even or Odd
    if (n % 2 == 0)
        "Even" // returned
    else
        "Odd" // returned
  }

  println(oddOrEven(10)) // Even
  println(oddOrEven((11))) // Odd
}
