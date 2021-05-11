object S38_Object extends  App {

  // object itself is an instance
  // singleton instance
  // we cannot create instance of instance
  object Logger {
    val logLevel : String = "INFO"
    def info(msg: String) = println( s"Info $msg")
    def warn(msg: String) = println( s"Warn $msg")
    def error(msg: String) = println( s"Error $msg")
  }

  println(Logger.logLevel)
  Logger.info("Starting the app")
  Logger.error("Error connecting db")



}
