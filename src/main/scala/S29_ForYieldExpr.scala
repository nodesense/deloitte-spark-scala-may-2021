object S29_ForYieldExpr extends  App {
  // using for loop as expression

  // yield accept an expression, it calculate, returns the value
  // this makes forloop returns output
  val list = for (i <- 1 to 5 reverse) yield i * 10
  println("List is ", list)

  def multi(n: Int) = {
    println("multi called", n)
    n * 10
  }

  val list2 = for (i <- 1 to 5) yield multi(i)
  println(list2)

}
