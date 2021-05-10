object S07_Method extends  App {
 // methods are resusable functions
  // accept 0, 1 or more arguments, return 0 or 1 argument
  // Unit is slighltly different than void

  // one line function, no block expression
  // Unit is void , no return output
  def hello(): Unit = println("Hello World")
  // multiline function
  def greeting(): Unit = {
    println("Good morning")
    println("Good afternoon")
  }

  // to call the functions
  hello()
  greeting()
}
