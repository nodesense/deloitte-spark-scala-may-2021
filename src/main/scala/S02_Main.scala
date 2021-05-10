object S02_Main {
  // main is keyword, for main function
  // Array[String] is generic, in java called as diamond <>
  // Unit is return type, Unit similar to void
  def main(args: Array[String]): Unit = {
    println("Hello World")
    println ("length " + args.length)
    println("Args ", args.toList)

    // do it yourself, pass the argument fors S02_Main via intelli configuation

    //java S02_Main.class scala spark "my thrid arg"
  }
}
