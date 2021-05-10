object S03_ImmutableVal extends  App {
  // Value type: const, we cannot change value/reference
  // Variable type, we can change the value

  // Value type
  // i is an int type, through type inference, compiler implicit
  val i = 10
  // explicitly mentioning type by developer
  val j: Int = 10

  // i = 20 error we cannot change value
  print (i, j)

}
