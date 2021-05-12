
Open command prompt, run cluster master aka cluster manager

```
spark-class org.apache.spark.deploy.master.Master
```

open command prompt Run Worker 1

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.1.110:7077
```


open command prompt Run Worker 1

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.1.110:7077
```

Open command prompt, run spark shell

```
spark-shell --master spark://192.168.1.110:7077
```


Check the port numbers on console for Web UI,

We have master Web UI and then   Web UI for Spark Tasks

