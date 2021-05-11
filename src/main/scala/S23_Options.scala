object S23_Options extends  App {
  // Options
  // two choices
  //  compute an expression
       // 1. we got result
       // 2. We got None

  // convert your exception to a return value in a way we can handle it
  def toInt(input: String): Option[Int] = {
    // return a int value convert from string
    try {
      // return some value if the expression execute successfully
      Some(input.toInt)
    }
    catch {
          // On error return None value instead of 0
      case _ => None
    }
  }

  println ("None ", None)
  println("Some ", Some(10))

  val o: Option[Int] = Some(20)
  val o2: Option[Int] = None

  val result: Option[Int] = toInt("23")
  // if result has success result or not
  if (result.isDefined) { // true if the value is Some
    println("result ", result)
    println("result value ", result.get) // return the result only if isDefined
  }

  val result2: Option[Int] = toInt("Nan") // cause exception

  if (result2.isDefined) { // false
    println("result2 defined ", result2 ) // not executed since isDefined false
  }

  if (result2.isEmpty)  { // true if the value is None
    println("result2 is empty, no value")
  }
}
