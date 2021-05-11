object S25_TryCatchExpression extends  App {
  // even  though the code works, substitute 0 in place error, not a right solution
  val result: Int = try {
                      // val r = 42 / 2 // return value 21
                      val r = 42 / 0
                      r // return value
                    }
                     catch {
                           // on error, return 0
                       case _ => 0
                     }

  // prints 21 if no error
  // or print 0 if there is an excepion
   println("result ", result)
}
