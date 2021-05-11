object S26_Either extends  App {
  // Either is an alternative to Option
  // Option either returns Some value or None value.

  // GET /resource/resource-1
  // 200 OK or
  // 404 Not found

  // Either is a type/class
  // Left and Right basically that create Either class instance
  // Left means, error, bad one
  // Right means, Good value, no error, 200

  val e1 : Either[String, Int] = Right(10/2)
  val e2 : Either [String, Int] = Left("Something wrong happend")

  println("E1", e1.right, e1.isRight, e1.isLeft)
  println("E2", e2.left, e2.isRight, e2.isLeft)

  def safeDiv(a: Int, b: Int): Either[String, Int] = {
    // if number is divisiable, return result as right else return Left with error
    if (b != 0) Right (a / b) else Left ("Divide by Zero")
  }

  def getProduct (id: Int) = {
     if (id % 2 == 0) Right ("200 OK") else Left("404 Not Found")
  }

  val x = safeDiv(10, 2)
  println("X ", x.isLeft, x.isRight)

  if (x.isRight) {
    println("Right value ", x.right.get)
  } else {
    println("Left value ", x.left.get)
  }


}
