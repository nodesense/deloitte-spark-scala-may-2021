object S20_ClassClassMemberConstructor extends  App {
  // class with constructor argument
  // constructor arguments are mentioned in the class name itself
  // primary constructor
  // name and price are constructor arguments, not MEMBER VARIABLEs
  class Product(name: String, price: Int) {
    println("Product created", name, price)
    // try to use special string construct in scala
    println(s"Product $name, $price")
  }

  val p1 = new Product("Iphone", 45000)
  // we cannot access name, price, since there are not member variable
 //p1.name  // error
  //p1.price // error

  // both val and var keywords make those constructor member variable
  // name, company are member variable of type public
  // year is a constructor argument
  class Brand(val name: String, var company:String, year: Int) {
     println(s"Brand $name, $company $year ")
  }

  val b1 = new Brand("Apple", "Apple Inc", 1978)
  // now we can access name and company since they ARE MEMBER VARIABLES of public scope
  // but we cannot access year, since it is constructor arg
  println(b1.name)
  println(b1.company)
  b1.company = "Apple, Inc" // allowed since company is public, variable type
  println(b1.company)
  // println(b1.year) // error since year is not member
}
