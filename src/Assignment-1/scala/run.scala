import scala.annotation.tailrec
import scala.math.abs

object run {

  def loopA(strList: List[String]): String = {
    var s = ""
    for (day <- strList)
      s += day + ", "
    s
  }

  def loopB(strList: List[String]): String = {
    var s = ""
    for (day <- strList)
      if (day.startsWith("S"))
        s += day + ", "
    s
  }

  def loopC(strList: List[String]): String = {
    var s = ""
    var i = 0
    while (i < strList.length) {
      s += strList(i) + ", "
      i += 1
    }
    s
  }

  def recursiveA(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.head + ", " + recursiveA(strList.tail)
  }

  def recursiveB(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.last + ", " + recursiveB(strList.splitAt(strList.length-1)._1)
  }

  def tailRecursion(strList: List[String]): String = {
    @tailrec
    def  iter( str: List[String], result: String): String = {
      if (str.isEmpty) result
      else iter(str.splitAt(1)._2, result + str.head + ", ")
    }
    iter(strList, "")
  }

  def increase_by_one( l: List[Int]): List[Int] = {
    l.map(x => x+1)
  }

  def absolute_value( l: List[Double]): List[Double] = {
    l.filter(_ <= 12 ).filter(_ >= -5).map(x => abs(x))
  }

  def tuple_print( t: (String, Double, Boolean) ) ={
    println(t._1, t._2, t._3)
  }

  def remove_zeros( l: List[Int]): List[Int] = {
    if( l.isEmpty ) List()
    else if( l.head != 0 ) List(l.head) ::: remove_zeros(l.tail)
    else remove_zeros(l.tail)
  }

  def main(args: Array[String]): Unit = {

    val daysOfWeek = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    // 1st part - loops
    println(loopA(daysOfWeek))
    println(loopB(daysOfWeek))
    println(loopC(daysOfWeek))
    // 2nd part - recursion
    println(recursiveA(daysOfWeek))
    println(recursiveB(daysOfWeek))
    // 3rd part - tail recursion
    println(tailRecursion(daysOfWeek))

    // 4th part - folding
    println(daysOfWeek.foldLeft("")(_ + _ + ", "))
    println(daysOfWeek.foldRight("")(_ + ", " + _))
    println(daysOfWeek.filter(_.startsWith("S")).foldLeft("")(_ + _ + ", ") )

    // 5th part
    val products = Map("chocolate" -> 5.0, "milk" -> 2.0, "juice" -> 3.5, "sandwich" -> 8.0)
    val reducedProducts = products.mapValues(x => x*0.9)
    println(reducedProducts)

    // 6th part
    val values = List(1, 3, 5, 7, 9)
    println(increase_by_one(values))

    // 7th part
    val numbers = List(2.3, 5.0, 45.66, -3.3, -9, 12)
    println(absolute_value(numbers))

    // 8th part
    val t = Tuple3("apple", 2.5, true)
    tuple_print(t)

    // 9th part
    val zeroValues = List( 2, 0, 7, 25, 15, 0, 6)
    val nonZeroValues = remove_zeros(zeroValues)
    println(nonZeroValues)


    // 10th part

  }

}
