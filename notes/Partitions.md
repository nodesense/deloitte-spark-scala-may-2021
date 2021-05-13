Input Data - hardcoded  - .parallize, textFile, csv/json/file system/hadoop/s3
read the input data, load into partitions

what is the partition
a chunk of whole data, subset of whole data
divide data into smaller units

data - [1,2,3,4,5,6,7,8,9, 10]

partitions: 1   , 2 , 3, 4...N..M partitions

MAX Paritions 1:
P0 : [1,2,3,4,5,6,7,8,9, 10]

MAX Paritions 2:
P0 : [1,2,3,4,5]
P1 : [6,7,8,9, 10]
or
p0: [IN, IN, IN.]
p1: [US, US, US]


MAX Paritions 4:
P0 : [1,2,3]
P1 : [,4,5,6]
P2 : [7,8]
P3 : [9, 10]


MAX Paritions 10:
P0 : [1,2,3]
P1 : [,4,5,6]
P2 : [7,8]
P3 : [9, 10]
p4,p5,p6,p7,p8,p9 = [] no data


Tasks:
.map(n => n * 10)
.map (error)


Create a Task - queue, task schduler all managed by Spark Driver / Spark Context with in driver
.map(n => n * 10)
.map (error)
Task in queue

        Queue: [Task 1, Task 2, .....]

Task Scheduler running with in driver
Pick a task from queue FIFO,
Driver shall Send task  to worker/executor to run the tasks + which partition assigned to task
(task1, Partition 2)
(task3, Partition 0)
(task2, Partition 3)
(task4, Partition 1)
Worker is compute node,
it is running Executor as a JVM process
receive the task
executor shall have threads inside
assign tasks to thread to run the task

         use block Manager to move the parition data to the worker node 
            
            move Partition 1 [,4,5,6] to worker to run 
                task is executed on given partition
                the result shall be stored in a partition on same worker 

driver
.collect() colect result from all paritions data

Fault Tolerance

Task Queue + Scheduler
(task1, Partition 2) - failed, retry on worker 2 , sucess on woker 2
(task3, Partition 0) - completed
(task2, Partition 3)
(task4, Partition 1)

Worker 1 - Crashed -
(task1, Partition 2) - parition data already moved, task is running - power cut on that worker machine due to smps

Worker 2
(task3, Partition 0) - success
(task1, Partition 2) - allcate tasks ,move the parition data
(task2, Partition 3)
(task4, Partition 1)


Worker 1:
task 1
P2 : [7,8]

----

    Tasks are run in parallell

    4 core system - 4 tasks at a time 
    1 core system - 1 tasks at a time 


100 tasks in queue
4 core system - 4 task at a time

    once  task is completed, pick another taks from queue, assign to executor core..
------

HashParition - works based on key by default 
State is a key, 

NY, 1234
OH, 3456
NY, 1256
CO, 5678
----

PartitionBy (HashPartition (3))
hashCode(NY) %  3 = 0 or 1 or 2 parition number
P0: [ (NY, 1234), (NY, 1256)]
P1: [ (OH, 3456), (CO, 5678), (OH, 3489),]
P2: 


(WV,UsZipCode(24935,Forest Hill,WV,SUMMERS,,37.648541,37.648541))
(WV,UsZipCode(24936,Fort Spring,WV,GREENBRIER,,37.975595,37.975595))
(NY,UsZipCode(00544,Holtsville,NY,SUFFOLK,,40.922326,40.922326))
(MA,UsZipCode(01001,Agawam,MA,HAMPDEN,,42.140549,42.140549))
(MA,UsZipCode(01002,Amherst,MA,HAMPSHIRE,,42.367092,42.367092))

.filter ( data => data.state = 'MA')
(MA,UsZipCode(01001,Agawam,MA,HAMPDEN,,42.140549,42.140549))
(MA,UsZipCode(01002,Amherst,MA,HAMPSHIRE,,42.367092,42.367092))