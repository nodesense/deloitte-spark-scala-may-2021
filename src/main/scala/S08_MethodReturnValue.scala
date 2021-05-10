object S08_MethodReturnValue extends  App {
  def getName(): String = "Scala"
  // Type inference applicable for return type too
  // return type is String only
  def getVersion() = "2.11"

  // multi line code, using block exp
  def getSparkVersion() = {
    // the last executed expression/value is returned automatically
    // mean, no return keyword needed in Scala
    "2.4.7"
  }

  // For return keyword to work, the type should be explicitly mentioned,
  def getFramework(): String = {
      return "Spark"
  }

  println(getName())
  println(getVersion())
  println(getSparkVersion())
  println(getFramework())


}
