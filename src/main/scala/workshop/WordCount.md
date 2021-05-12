Input:
apple orange
spark apple
apple
jvm scala
python
jvm java
apple
orange apple

.flatMap( line => line.split(" "))

apple
orange
spark
apple
...

.map (word => (word, 1)) // a tuple (apple, 1)
produces tuple, first element in tuple is apple, value is 1

(apple, 1) < -- 
(orange, 1)
(spark, 1)
(apple, 1)
(apple, 1)

.reduceByKey( (acc, value) => {
println(s"acc $acc, value $value")
acc + value
})

Table 

key         accumulator_value
apple           2   -- initializer value/first value
                            -- calls (acc, value) => 
                               (1, 1)    => 1 + 1 = 2
                                            the output 1 set to accumulator table
                                (2, 1)    => 3 + 1 = 3
                                
                                the output 3 set to accumulator table

orange          1    (0, 1) => 0 + 1 = 1, set 1 for orange

spark           1      (0, 1) => 0 + 1 = 1, set 1 for spark

                    