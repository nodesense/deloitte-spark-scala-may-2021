object S39_CompanionObject extends  App {
  // Companion object is when a class name and object name  are same and
  // both should be located on the same file

  // new keyword? used to create object of classes
  // new is not a functional
  // companion object concept in scala to help to create object without using new keyword
  class Brand(val name: String, val year: Int) {
  }

  // how do we create object without using new keyword
  val b1 = new Brand("Apple", 1997);

  // now create companion object with same class name
  // object Brand is a companion object for Brand class
  // apply is a keyword in companion object
  // useful to create object
  object Brand {
    def apply() = new Brand("", 0)
    def apply(name: String, year: Int) = new Brand(name, year)
  }

  // see creating object without new keyword
  val b2 = Brand() // calls Brand.apply()
  val b3 = Brand("Apple", 1977) // calls Brand.apply(name: String, year: Int)
  println(b3.name, b3.year)
}
