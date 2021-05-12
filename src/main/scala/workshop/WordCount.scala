package workshop
import org.apache.spark.sql.SparkSession

object WordCount extends  App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[2]")
    .appName("SparkHelloWorld")
    .getOrCreate()


  spark.sparkContext.setLogLevel("WARN")

  val sc = spark.sparkContext

  val textFile = sc.textFile("file:///c:/data/input.txt")
  println("Lines ", textFile.count())
  println("All lines ", textFile.collect().toList)

  val wordCount = textFile.flatMap( line => line.split(" "))
                          .map (word => (word, 1)) // a tuple (apple, 1)
                          .reduceByKey( (acc, value) => {
                            println(s"acc $acc, value $value")
                            acc + value
                          })

  println("Word Count ", wordCount.collect().toList)

}
