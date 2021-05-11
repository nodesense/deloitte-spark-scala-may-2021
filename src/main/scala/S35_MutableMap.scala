import scala.collection.mutable.Map
object S35_MutableMap extends  App {
  // Hashtable, Dictionary in python
  // Key, value pair, key should be unique
  // map is formed from 2 value tuple
  val map= Map[String, String] ("KA" -> "Karnataka",
                                       ("TN", "Tamil Nadu"))

  println(map)

  val t = ("KL", "Kerela")

  map += "AP" -> "Andra Pradesh"
  map += t
  println(map)

  map -= "KL"

  println(map)
}
