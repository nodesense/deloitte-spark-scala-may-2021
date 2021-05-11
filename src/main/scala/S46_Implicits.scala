object S46_Implicits extends  App {
  // implicit, compiler implicits
  // you need to pass the parameter, but the can do this automatically

  // block 1
  {
      implicit  val k : Int = 1
      // Note: look at the type, implict is declared as Int, b aslo declared with implicit Int
      def add(a: Int) (implicit  b:Int) = a + b

     println(add(10)) // a = 10, b = 1 is implicit by compiler
     println(add(20)(5)) // a = 20, b = 5, now implicit is not used
  }

  // block 2, implicit for type conversion
  {
     implicit  def dToI(d: Double) = {
       println("dToI called")
       d.toInt
     }
     val x: Int = 42.0
  }

}
