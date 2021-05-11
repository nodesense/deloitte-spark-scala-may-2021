object S43_MatchCase extends  App {
  // Java, switch case, statement
  // in Scala, we have match case, match case is an expression, that returns value

  val n = 12
  val result = n % 2 match {
    case 0 => "Even" // Even is returned
    case 1 => "Odd" // Odd is returned
  }

  println(result)

  val m = 10 // 4 or 5 or 10
  m match {
    case 0 | 2 | 4 | 6 => println("M is even number")
    case 1 | 3 | 5      => println("M is odd number")
    // default case
    case _ => println("Unknown number")
  }

  // case with guard if
  def tempRange(n: Int) = n match {
    case t:Int if (t <= 16) => s"Cold $t"
    case t:Int if (t > 16 && t <= 26) => s"Normal $t"
    case t:Int if (t > 26) => s"Hot $t"
  }

  println(tempRange(15))
  println(tempRange(20))
  println(tempRange(40))


}
