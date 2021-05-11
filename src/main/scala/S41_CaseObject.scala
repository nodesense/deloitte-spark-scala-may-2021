object S41_CaseObject extends  App {
  // case object, where we need only singleton instance of case class
  // we don't need to create case class, instead  you can use case object

  // scala writes a class behind, also overwrites toString function there
  // toString that returns "GetProducts"
  case object GetProducts { }

  case object MobileCategory{
  }

  // use the object without any creation of instances
  println(GetProducts)
}
