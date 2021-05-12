package workshop

import org.apache.spark.sql.SparkSession

object SparkHelloWorld extends  App {
  //local[1] - 1 parallel tasks, default partitions shall be set to 1
  //local[2] - 2 parallel tasks, default partitions 2

  val spark: SparkSession = SparkSession.builder()
    .master("local[2]")
    .appName("SparkHelloWorld")
    .getOrCreate()


  spark.sparkContext.setLogLevel("WARN")

  val sc = spark.sparkContext

  val rdd = sc.parallelize( Seq("Java", "Scala", "Spark") )
  println(rdd.getNumPartitions)

  rdd.foreach(println) // for every element, println is called


}