object S05_PrimitiveTypes extends  App {
  // Primitive types in scala are value types in Java
  // however scala treat primitive also a class at compile time
  // at runtime, while generate class code, it matches with JVM type, ie java primitives

  val enabled: Boolean = true // false
  val byteA: Byte = 120; // 8 bit  -128 to 127
  val s : Short = 3200; // 16 bit
  val i : Int = 32; // 32 bit
  val l : Long = 92343423423423243L // 64bit, the L at the end means, long type
  val f: Float = 3.14f ; // f or F suffix to say it is float number // 4 bytes
  val d: Double = 3.14 ;  // 8 bytes range

  val c: Char = 'C'; // 2 bytes, unicode compatible

  // Scala drive all the primitive types from a class AnyVal
  val a : AnyVal = 23
  val b : AnyVal = d
  // Any is super class of AnyVal
  val aa : Any = f

  println("A", a)



}
