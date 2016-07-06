package week6

object maps {
  
  val capitalOfCountry = Map("US" -> "Washington") withDefaultValue "default value"
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington)
  
  capitalOfCountry("US")                          //> res0: String = Washington
  capitalOfCountry("Brasil")                      //> res1: String = default value
 
  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(c) => println(c)
    case None => println("missing data")
  }                                               //> showCapital: (country: String)Unit
}