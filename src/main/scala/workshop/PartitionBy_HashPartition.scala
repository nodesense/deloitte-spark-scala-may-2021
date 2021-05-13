package workshop

import org.apache.spark.HashPartitioner

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object PartitionBy_HashPartition extends  App {
  val spark:SparkSession = SparkSession.builder()
    .master("local[2]") // [x] is a number of parallel task, same used for default partititon
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

  val header = textFile.first() // action, create a task, execute stages, tasks
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
    .partitionBy(new HashPartitioner(5)) // 3 max partitions

  // key shall be used for parition


  //println(rdd2.collect().toList)
  println("partitions ", rdd3.getNumPartitions)

  // collect data from paritions
  // glom collect data to driver
  // blocking call
  val partitionData = rdd3.glom()


  // (1,10) => Tuple2[Int, Int]
  // Tuple2[String, UsZipCode] == (String, UsZipCode)
  def printData(list: Array[Tuple2[String, UsZipCode]]) = {
    println("------------")
    list.foreach(println)
  }

  // action, create a task, execute stages, tasks
  partitionData.foreach(data => printData(data) )


  // to process data per partitition

  rdd3.foreachPartition(partition => {
    // this code shall run in the worker node, task
    // paralling processing applied

    val result   = new scala.collection.mutable.ArrayBuffer[(String, UsZipCode)]()
    partition.foreach( data => {
      result += data
    })

    println("---Part --------begin")
    println(result.toList)
    println("---Part --------end")
    // process the record in the partition, like
    // storing to database
  })


  // println("Press any key to exit")
  // scala.io.StdIn.readLine()
}
