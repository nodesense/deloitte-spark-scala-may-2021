object S17_ForLoop extends  App {
 // forloops are iterators, syntatic sugar in scala
  for (i <- 1.to(5)) // 1, 2, 3, 4, 5
    print(" " + i)

  println()
  for (i <- 1.until(5)) // 1, 2, 3, 4
    print(" " + i)

  // sugar part
  println()
  for (i <- 1 to 5)
    print(" " + i)

  println()
  // for (i = 0 ; i < 10; i= i+=2
  for (i <- 1 to 10 by 2)  // 1, 3, 5, 7, 9
    print(" " + i)

  // For loop with if guard
  for (i <- 1 to 10 if i % 2 == 0)
    println("i", i)
}
