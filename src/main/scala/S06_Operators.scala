object S06_Operators extends App {
  // arithmatic + - / * %
  val i = 10 + 2
  // relational   == != < > <= >=, returns boolean output
  val result = 10 > 5 // Boolean true

  // logical && (and), || (or), ! (not)
  val result2 = (10 > 2) && (2 < 10) // AND, both should be true
  val result3 = (10 > 2) || (2 > 10) // OR , if any one part is true, whole part is true

  val result4 = !(10> 2) // negation true to false

  println ("i", i)
  println ("result", result)
  println ("result2", result2)
  println ("result3", result3)
  println ("result4", result4)
}
