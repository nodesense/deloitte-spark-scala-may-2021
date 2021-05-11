object S31_ForComprehensionWithOption extends  App {
  val opt1 = Some(10);

  val result = for {value <- opt1} yield value;
  println("result ", result)

  val opt2 = None
  val result2 = for {value <- opt2} yield value;

  println("REsult2 ", result2)
}
