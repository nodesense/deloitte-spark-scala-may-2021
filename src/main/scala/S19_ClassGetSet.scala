object S19_ClassGetSet extends  App {
  // learn scala styled getter and setter
  class Product {
     private var _discount = 0

     def discount = _discount // getter
     // setter
     // No space between discount_=, special scala construct
    // discount_= whole string itself a method name
     def discount_= (value: Int) = _discount = value
  }

  val p1 = new Product();
  println(p1.discount) // calls getter
  p1.discount = 20 // calls setter discount_=
  println(p1.discount)
}
