
Open command prompt, run cluster master aka cluster manager

```
spark-class org.apache.spark.deploy.master.Master
```

Now check, http://localhost:8080/

open command prompt Run Worker 1

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.1.110:7077
```


open command prompt Run Worker 1

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.1.110:7077
```

Open command prompt, run spark shell with default config

```
spark-shell --master spark://192.168.1.110:7077
```

Stop the spark shell, 

start the spark shell with specific requirements..

spark-shell --master spark://192.168.1.110:7077 --driver-memory 6G --executor-memory 4G --executor-cores 2


Check the port numbers on console for Web UI,

Copy paste code below


val rdd = sc.parallelize ( 1 to 10)

val rdd2 = rdd.map (n => n * 10)

rdd2.collect()

We have master Web UI and then   Web UI for Spark Tasks

