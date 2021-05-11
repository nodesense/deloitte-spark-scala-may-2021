object S40_CaseClass extends  App {
   // Case class is sugar
  // Case class is a class with companion object automatically
  // case members are value type by default
  // used heavily in scala/spark
  // used for representing a data, record from db
  // scala generate toString function, used in print
  case class Employee(name: String, salary: Double);


  // create instane without new keyword
  val e1 = new Employee("Joe", 8000)
  // create object without new keyword, since scala shall write companion object automatically
  val e2 = Employee("Mary", 9500) // most preferred

  println(e1.name, e1.salary)
  println(e2)

}
