// Databricks notebook source
sc.parallelize(List(1,2,3)).collect()

// COMMAND ----------

val ratingDf = spark.read
              .option("header", true)
              .option("inferSchema", true) // scan the file content, automatically detect column types
              .csv("/FileStore/tables/ratings.csv")
ratingDf.printSchema()
ratingDf.show(2)

// COMMAND ----------

// DataFrame, SQL are APIs over RDD
println(ratingDf.rdd.getNumPartitions)
println("default partittion", sc.defaultMinPartitions)
println("default Parallel", sc.defaultParallelism)


// COMMAND ----------

ratingDf.rdd.take(2)

// COMMAND ----------

// Spark will another DataFrame, since dataframe is immutable
val df = ratingDf.select("movieId", "rating")
df.show(2)


// COMMAND ----------

val df2 = ratingDf.filter ( ratingDf("rating") < 1.0)
df2.show(2)

// COMMAND ----------

// Syntatic suger for column names
// Spark code, has overloaded single quote ' that represent column
// Scala syntax
ratingDf.filter('rating < 1.0).show(2)

// COMMAND ----------

// Filter with SQL statement
df.filter (" rating < 1.0 ").show(2)
// where function, which is alias of filter, where === filter
df.where("rating < 1.0").show(2)


// COMMAND ----------

ratingDf.filter ( 'rating >=1 && 'rating <=2).show(10)

// COMMAND ----------

// SQL
ratingDf.where (" rating >= 1 AND rating <=2 ").show(10)

// COMMAND ----------

// adding new columns , by driving from existing

val df4 = ratingDf.withColumn("rating_adjusted", 'rating + 0.2)
df4.printSchema()
df4.show(2)


// COMMAND ----------

// add new column, drop the column
val df4 = ratingDf.withColumn("rating_adjusted", 'rating + 0.2)
                  .drop("rating")
df4.printSchema()
df4.show(2)


// COMMAND ----------

// rename columns
 val df5 = ratingDf.withColumnRenamed("rating", "rating_adjusted")
                   
df4.printSchema()
df4.show(2)

// COMMAND ----------

import org.apache.spark.sql.types.{StructType, StringType, IntegerType, ByteType, FloatType, DoubleType}
// better than using inferSchema
// movieId,title,genres
val movieSchema = new StructType()
                      .add("movieId", IntegerType)
                      .add("title", StringType)
                      .add("genres", StringType)
                    
val movieDf = spark.read
              .option("header", true)
              .schema(movieSchema)
              .csv("/FileStore/tables/movies.csv")

movieDf.printSchema()
movieDf.show(2)

// COMMAND ----------

// parquet
println(movieDf.rdd.getNumPartitions)
movieDf.write.mode("overwrite").parquet("/FileStore/tables/movies/parquet/movie-data")
// movieDf.repartition(4).write.mode("overwrite").parquet("/FileStore/tables/movies/parquet/movie-data")

// COMMAND ----------

// csv
println(movieDf.rdd.getNumPartitions)
movieDf.write.mode("overwrite").option("header", true).csv("/FileStore/tables/movies/csv/movie-data")
// movieDf.repartition(4).write.mode("overwrite").parquet("/FileStore/tables/movies/parquet/movie-data")

// COMMAND ----------

// most popular movies,
// group by movieId, count for aggregate
import org.apache.spark.sql.functions.{count}

val df = ratingDf
          .groupBy('movieId)
          .agg(count('userId))

df.show(10)

// COMMAND ----------

// most popular movies,
// group by movieId, count for aggregate
//import org.apache.spark.sql.functions._ // import all
import org.apache.spark.sql.functions.{count, col, desc}
// import org.apache.spark.sql.{functions => F}; // rename/alias

//F.count

val df = ratingDf
          .groupBy('movieId)
          .agg(count('userId).alias("total_ratings"))
          .filter(col("total_ratings") >= 100)
          .sort(desc("total_ratings")) // desc
          //.sort('total_ratings) // asc
          //.withColumnRenamed("count(userId)", "total_ratings")

df.show(false)

// COMMAND ----------

// most popular movies,
// group by movieId, count for aggregate
//import org.apache.spark.sql.functions._ // import all
import org.apache.spark.sql.functions.{count, col, desc, avg}
// import org.apache.spark.sql.{functions => F}; // rename/alias

//F.count

val df = ratingDf
          .groupBy('movieId)
          .agg(count('userId).alias("total_ratings"), avg('rating).alias("avg_rating"))
          .filter( (col("total_ratings") >= 100) &&   (col("avg_rating") >= 4) )
          .sort(desc("total_ratings")) // desc
          //.sort('total_ratings) // asc
          //.withColumnRenamed("count(userId)", "total_ratings")

df.show(100)



// COMMAND ----------

val mostPopularMoviesDf = df.join(movieDf, df("movieId") === movieDf("movieId")  , "inner")
mostPopularMoviesDf.show(100)

// COMMAND ----------


