object S44_MatchCaseCaseClass extends  App {

 trait Product{}

 case class MobileProduct(name: String) extends Product
 case class  Vaccine(name: String) extends Product
 case class Book(name: String, price: Int) extends Product

 def isTaxable(product: Product) = product match {
  case m:MobileProduct => true
  case v: Vaccine => false
  case b: Book if b.price < 200 => false
  case b: Book => true
   // all others
  case _ => true
 }

 println(isTaxable(MobileProduct("iPhone")))
 println(isTaxable(Vaccine("Covaxin")))
 println(isTaxable(Book("Learning Scala", 600)))
 println(isTaxable(Book("Learning Kannada", 150)))

}
