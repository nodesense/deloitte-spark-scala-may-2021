object S22_ClassInheritance extends  App {
  // Inheritance is basically to reuse class implementation
  // so that we don't need to repeat code again
  class Product(val name: String, val price: Double, protected var discount: Double) {

     def grantTotal() = price - (price * discount/100.0)

  }

  // the value of name, price, discount is passed to base class constructor for initialization
  class RetailProduct(name: String, price: Double, discount: Double) extends Product(name, price, discount) {
  }

  class WholeSaleProduct(name: String, price: Double, discount: Double, val gst: String)
                                                                        extends Product(name, price, discount) {
    // super.grantTotal() calls base  class grantTotal() returns discounted price
    // we add gst on wholesaleproduct
     override def grantTotal(): Double = super.grantTotal() * 1.18 // 18% GST
  }

  val rp1 = new RetailProduct("Galaxy", 10000, 20)

  println(rp1.grantTotal()) // 8000 calling base class/product class member

  val wp1 = new WholeSaleProduct("iPhone", 10000, discount = 20, "PANFDSAFSDAFDSAFDSA");
  println(wp1.grantTotal()) //  9440
}
