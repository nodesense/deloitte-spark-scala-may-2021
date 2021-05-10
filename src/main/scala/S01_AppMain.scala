// We can extends App Trait, which implements main already
object S01_AppMain extends  App {
  // ran first time if we extend from App trait
  println ("Hello World")
  // command line arguments, you can access via App trait
  println ("Commmand line args " + args.length)
  println ("args ", args.toList)

  // in intellij configuration, try to pass command line arg
}
