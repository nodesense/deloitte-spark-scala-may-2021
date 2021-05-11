object S47_ParameterGroup extends  App {
  // normal method
  def add(a: Int, b: Int, c: Int) = a + b + c
  // parameter group, curry pattern
  def sum(a: Int) (b: Int) (c: Int) = a + b + c
  // reusable computation, configuration in functional pattern

  println(add(10, 20, 30)) // 60
  println(sum(10)(20)(30)) // 60
  // sum _ convert method to function
  val sum10 = (sum _) (10) // a = 10
  val sum10plus15 = sum10(15) // a = 10, b = 15
  val sum10plus25 = sum10(25) // a = 10, b = 25

  println(sum10plus15(45)) // c = 45, outputs 70
  println(sum10plus15(20)) // c = 20, outputs 45

  println(sum10plus25(20)) // c = 20, outputs 55
}
