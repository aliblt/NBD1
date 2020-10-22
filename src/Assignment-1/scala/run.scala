import scala.annotation.tailrec

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
    else strList.head + ", " + recursiveA(strList.splitAt(1)._2)
  }

  def recursiveB(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.tail.toString() + ", " + recursiveA(strList.splitAt(-1)._1)
  }

  @tailrec
  def tailRecursion(): String =

  val daysOfWeek = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

  def main(args: Array[String]): Unit = {
    println(loopA(daysOfWeek))
    println(loopB(daysOfWeek))
    println(loopC(daysOfWeek))
    println(recursiveA(daysOfWeek))
    println(recursiveB(daysOfWeek))
  }

}
