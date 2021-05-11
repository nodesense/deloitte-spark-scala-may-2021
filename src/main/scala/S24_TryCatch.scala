object S24_TryCatch extends  App {
  // Scala support Try Catch
  // Scala's Try Catch is an expression, means that returns a  value

  // this throw exception, halt program execution
  // handle and swallow exception

  try {
    val result = 42 / 0 // 42 / 2

    println(result)
  } catch {
    // called when there is an exception
    // _ means default
    case _ => println("Exception")
  }finally  {
    // statements/expression
    // called on exception also no exception
    // close db connection, close file
    println("Finally called")
  }

  println("After exception")
}
