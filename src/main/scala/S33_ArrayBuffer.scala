// mutable collection, means, allows add/remove/
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object S33_ArrayBuffer extends App {
  // mutation
  // Linked List basic
  // [10, next] --> [20, next] --> [25, next=nil]
  // access element, O(n) - n is number of elements in the list
  val list: ListBuffer[Any] = ListBuffer(10, 20, 25)
  list.append(30)
  list += 40

  println(list)

  list -= 20 // remove 20
  println(list)

  // Big O (n)
  list.update(0, 15) // change 10 to 15
  println(list)

  // Big O(n)
  println(list(0)) // 0 is list index , 15
  println(list(3)) // 3 is list index - 40

  // ArrayBuffer
  // Similar to array []
  // Big O (1)
  // array = [ 10, 20 ,30, 40]
  // array[2] == 30 Big O(2)

  val arr1 = ArrayBuffer(10, 20, 30)
  arr1 += 40
  println(arr1)
  arr1 -= 20
  println(arr1)
  // big O(1)
  arr1.update(0, 15)
  println(arr1)

  println(arr1(0)) // get 0th index
}
