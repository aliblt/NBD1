import scala.Console.in

class Maybe[A](var value: A) {
  def map[B](f: A => B): Maybe[B] = {
    val newValue = f(value)
    new Maybe(newValue)
  }
  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    val newValue = f(value)
    newValue
  }
  override def toString: String = value.toString
}

class Yes[A](value: A) extends Maybe[A](value) {
  private val v: A = value
  def getContent: A = v
}

object Maybe {
  def apply[A](value: A): Maybe[A] = new Maybe(value)
}

object Yes {
  def apply[A](value: A): Yes[A] = new Yes(value)
}

object run10 extends App {

  // Task1 ------
  println("Task 1:")
  def pair: Iterator[(Int, Int)] = for {
    a <- Iterator.from(1)
    b <- 1 until a + 1 if a % b == 0
  } yield (a, b)

  println("20 first elements (take):")
  pair.take(20).foreach(println)

  println("20 first elements (next):")
  var p = pair.buffered
  for (_ <- 1 to 20) {
    println(p.next)
  }

  // Task2 -----
  println("Task 2:")
  val mapMethod = for {
    a <- Yes("hello world")
  } yield a
  println(mapMethod)
}