object S45_ByNameCalling extends  App {
  def nano() = {
    println("nano called")
    // return time millis
    System.nanoTime()
  }

  def example(t: Long) = {
    println("In example")
    println("Time is ", t)
  }

  example(nano())

  println("-------")

  // t: => Long is a block that returns long value
  def delayed(t: => Long ) = {
    println("In delayed")
    println("Time is ", t)
  }

  // nano() is not evaluated immediately here, instead it is evaluated in delayed func
  delayed(nano())
  // code block is not evaluated immediately here, instead it is evaluated in delayed func
  delayed( {
            println("in block")
            100000
          })
}
