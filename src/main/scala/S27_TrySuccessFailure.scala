object S27_TrySuccessFailure extends  App {
  import scala.util.{Try, Success, Failure}
  // Try, Success, Failure - in built
  // Option - Something, None - error/exception is not exposed
  // Either , Right / Success, LEft / failure reason  - exception is not exposed

  // Try/Succes/Failure - Value if all is well, Or Exception if something went wrong

  def safeDiv(a: Int, b: Int): Try[Int] = Try(a / b)

  val x = safeDiv(10, 2) // Success, no error
  if (x.isSuccess) {
    println("Success", x.get)
  }

  val y = safeDiv(10, 0)
  if (y.isFailure) {
    println("Failed ", y.failed.get)
  }

  val k : Try[Int] = Success(5)
  // val p : Try[Int] = Failure(t) // t is throwable
}
