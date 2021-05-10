object S09_MethodArgReturn extends  App {
  // Int is type inference as return value
  def add(a: Int, b: Int) = a + b

  def sub(a: Int, b: Int): Int = {
    println(a, b)
    // return value
    a - b
  }

  def power(n: Int) = n * n

  println("Add", add(1,2))
  println("Sub", sub(10, 5))
  println("power", power(4))
}
