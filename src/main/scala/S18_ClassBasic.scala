object S18_ClassBasic extends  App {
  // Class is a blueprint of an object
  // class is a object factory where we can create many instances

  class Product {
    // no public keyword in scala
    // by defult, all members are public
    var name = "iPhone"; // member variable, public Scope

    // accessible only with in product, not outside
    private var price: Int = 100;

    // java styled getter / setter
    // def member method
    def setPrice(value: Int)  = price = value  // setter, set price value
    def getPrice(): Int = price  // getter, return price value

    // python __init__, in Java, we have constructor, similarly
    // this line within your class body
    // class constructor code here
    println("Product created")
  }

  // p1 is an instance, object of PRoduct class
  val p1 = new Product(); // this calls class constructor, print Product created
  // in python, we could do p1.somePrice = 100 where somePrice is called as attribute, not in scala
  // p1.somePrice = 100; // will not work
  println("name is ", p1.name)
  p1.name = "Pixel"
  println("name is ", p1.name)

   // p1.price  // error since price is private
  // call setPrice
  p1.setPrice(200)
  println(p1.getPrice())
}
