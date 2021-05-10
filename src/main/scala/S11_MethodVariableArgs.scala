object S11_MethodVariableArgs extends  App {

  // a method accept as many parameters

  // * means, multiple args it can be 0 , 1 ,as many
  // names is an array
  def greet(msg: String, names: String*) = {
    print(msg)
    print(names.toList)
    println()
  }

  greet("GM") // no names passed
  greet("GF", "Krish", "Nila") // names has two elements Krish, Nila
  greet("GN", "Joe", "July", "Mary") // names has 3 elements

}
