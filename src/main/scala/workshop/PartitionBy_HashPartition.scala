package workshop

import org.apache.spark.HashPartitioner

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object PartitionBy_HashPartition extends  App {
  val spark:SparkSession = SparkSession.builder()
    .master("local[4]") // [x] is a number of parallel task, same used for default partititon
    .appName("SparkByExample")
    .getOrCreate()

  val sc = spark.sparkContext
  spark.sparkContext.setLogLevel("WARN")


  case class UsZipCode (code: String,city: String,state: String,county: String,
                          area_code: String,lat:String,lon:String)


  // create 4 paritions
  //val textFile = sc.textFile("file:///C://data//all_us_zipcodes.csv", 4)

  // by default 2 paritions
  val textFile = sc.textFile("file:///C://data//all_us_zipcodes.csv")

  val header = textFile.first()
  println("textFile partitions ", textFile.getNumPartitions)

  val rdd2:RDD[Array[String]] = textFile.map(line => line.trim()) // remove all white space around
                                        .filter(line => !line.isEmpty)
                                        .filter (line => line != header)
                                        .map(m=>m.split(","))
                                        .filter(arr=> arr.length == 7)

  //println(rdd2.first().toList)
  val rdd3 = rdd2.map(arr => UsZipCode(arr(0),arr(1), arr(2),
    arr(3), arr(4), arr(5), arr(6))   )
    .map (zipCode => (zipCode.state, zipCode) ) // making key/value pair rdd
    .partitionBy(new HashPartitioner(50)) // 3 max partitions
  // key shall be used for parition


  //println(rdd2.collect().toList)
  println("partitions ", rdd3.getNumPartitions)

  // collect data from paritions
  val partitionData = rdd3.glom()

  def printData(list: Array[Tuple2[String, UsZipCode]]) = {
    println("------------")
    list.foreach(println)
  }

  partitionData.foreach(data => printData(data) )
}
