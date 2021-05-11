object S28_OptionCollection extends  App {
  def toInt(input: String): Option[Int] = {
    println("toInt called", input)
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

  val numbers = List("10", "20", "NaN", "Blr", "noData", "", "30", "40");

  //def toInt2 (n: String) = n.toInt
  // val results  = numbers.map (toInt2)

  val results: List[Option[Int]] = numbers.map (toInt)
  println("results ", results)

  // now filter out the None values
  val results2: List[Option[Int]] = numbers.map (toInt)
                                           .filter(option => option.isDefined )
  println("results2 ", results2)

  // Get list of clean numbers
  val results3: List[Int] = numbers.map (toInt)
                                    .filter(option => option.isDefined )
                                    .map(option => option.get)

  println("results3 ", results3)
}
