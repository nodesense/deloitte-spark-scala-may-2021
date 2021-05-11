object S32_List extends  App {
   // List is seq of element
  // Scala has two types of collection
  // 1. mutable [append, remove, update]
  // 2. immutable [values cannot added, changed, removed]

  val list1 = List(1, 2, 3, 4, 5)
  val states1 = List("KA", "AP", "TN")
  val states2 = List("MH", "GU", "RJ")

  val emptyList = Nil // empty list
  // right association, only for list, Nil
  // :: right associativity, bind elements right to left,
  val names = "iPhone" :: "Galaxy" :: "Nexus" :: Nil;

  val s = "test " + "test2"

  println(names)

  println("length", states1.length)
  println("First element ", states1.head)
  println("Last elements execluding the first one", states1.tail)
  println("is empty ", states1.isEmpty)
  println("is empty ", emptyList.isEmpty)

  // cancat two list
  val states = states1 ::: states2
  println(states)
}
