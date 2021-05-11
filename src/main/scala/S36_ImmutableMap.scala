object S36_ImmutableMap extends  App {
  // Immutable map from scala.collection.immutatble.Map, default
  val map = Map[String, String] ( ("KA"-> "Karnataka"),
    ("TN" -> "TamilNadu")) ;

  println(map)

  // create a new mutable map from immutable map
  val mutMap = scala.collection.mutable.Map() ++ map

  mutMap += ("KL" -> "Kerala")
  println(mutMap)

}
