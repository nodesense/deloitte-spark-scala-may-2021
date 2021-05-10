object S21_ClassConstructorMembers extends  App {
  // define a class with constructor, with access specifier public, private, protected
  // name is value type, member variable, we cannot change value
  // price is value type, member variable, private access, only Product class can access
  // discount is variable type, member variable, protected access, Product and its sub classes can access
  // year is constructor argument, value type
  class Product(val name: String, private val price: Int, protected var discount: Int, year: Int) {
      println("product created", year)

    //toString method, called automatically when we print object
    override def toString: String = s"Product($name,$price,$discount)"
  }

  val p1 = new Product("Pixel", 30000, 20, 2016)
  println(p1) // calls toString implicit
  print (p1.name)
  // p1.price is private, p1.discount protected, can't be accessibel here
}
