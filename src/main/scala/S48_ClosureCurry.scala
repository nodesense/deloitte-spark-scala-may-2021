object S48_ClosureCurry extends  App {
  // closure, the visiblity/scope/life of the variable remain active, even the function call exited
  // closure,maintain a encapsulation within functional programming
  // closure, maintain a state within a function
  // curry, a function that returns another function is called curry function

  // generate seq, 1, 2, 3,
  // generate seq 10, 20 ,30

  //input, Int, Int
  // output: a function that return an Int
  def seq(seed: Int, step: Int = 1): () => Int = {
    // a state
    var count = seed

    val incr = () => {
      // visiblity of count exposed to internal function
      val c = count
      count += step
      c
    }

    //return a function, called curry
    incr
  }

  //seq1By1 is a curry function incr
  val seq1By1 = seq(1) // seed = 1, step = 1
  //seq10By10 is a curry function incr
  val seq10By10 = seq(10, 10)

  println("seq1By1", seq1By1())
  println("seq1By1", seq1By1())
  println("seq1By1", seq1By1())

  println("seq10By10", seq10By10())
  println("seq10By10", seq10By10())
  println("seq1By1", seq1By1())
}
