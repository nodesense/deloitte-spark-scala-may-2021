object S34_Tuple extends  App {
  // Tuple, collection of related elements
  // immutable
  // create tuple using (), type compatible
  // person data name, age, gender, salary
  // index start from _1, compile time
  val t1 = ("Jhon", 30, 'M', 4566.00)
  println(t1)
  // access tuple using _1,.. _n
  println(t1._1, t1._2, t1._3, t1._4)

  val t2 = ("KA", "Karnataka")
  println(t2)
  println(t2._1)

  //create tuple using ->
  // key value pair
  val t3 = ("KA" -> "Karnataka" )
  println(t3)
  println(t3._1, t3._2)

  // ((KA,Karnataka),29)
  val t4 = ("KA" -> "Karnataka" -> 29 )
  println(t4)
  println(t3._1, t3._2)

  val u: Unit = () // Unit is an empty tuple


}
