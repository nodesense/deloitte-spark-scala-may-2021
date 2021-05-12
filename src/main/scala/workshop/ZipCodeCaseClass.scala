package workshop

import org.apache.spark.sql.SparkSession

object ZipCodeCaseClass extends  App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[2]")
    .appName("SparkHelloWorld")
    .getOrCreate()


  spark.sparkContext.setLogLevel("WARN")

  val sc = spark.sparkContext

  val textFile = sc.textFile("file:///c:/data/zipcodes.csv")

  case class ZipCode (area: String, pincode: String, state: String)

  val header = textFile.first()

  val pincodes = textFile.filter (line => line != header) // skip first line
                         .map(line => line.trim()) // remove all white space around
                         .filter(line => !line.isEmpty) // no emply line
                         .map(line => line.split(","))
                         .map(arr => ZipCode(arr(0), arr(1), arr(2))) // create object
                          .filter (zipCode => zipCode.state == "TN")

  pincodes.foreach(println)

}
