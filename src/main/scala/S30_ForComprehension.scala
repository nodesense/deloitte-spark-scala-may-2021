object S30_ForComprehension extends  App {

  val result = for { i <- 1 to 5 } yield i * 10
  println(result)

  // nested for loop,
  val result2 = for {
    i <- 1 to 5
    c <- List('S', 'C', 'A', 'L', 'A')
  } yield (i, c)

  println(result2)
}
