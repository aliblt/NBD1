object run9 {

  class Container[A](value: A) {
    private var _value: A = value
    def getContent: A = _value
    def applyFunction(f: A=>A): A = {
      _value = f(_value)
      _value
    }
  }

  trait Maybe[A] {
  }

  class No extends Maybe[Nothing] {
  }

  class Yes[A](value: A) extends Maybe[A] {
    private val v: A = value
    def getContent: A = v
  }

  class Task3[A](value: A) {
    private var _value: A = value
    def getContent: A = _value

    def applyFunction(f: A => A): A =
    {
      f(_value) match {
        case _: No => _value
        case _: Yes[_] =>
          _value = f(_value)
          _value
        case _ => null.asInstanceOf[A]
      };
    }
  }

  class Task4[A](value: A) {
    private var _value: A = value
    def getContent: A = _value
    def getOrElse[B]: B =
    {
      _value match {
        case _: No => return "This is class NO with no content".asInstanceOf[B]
        case _: Yes[_] => return _value.asInstanceOf[Yes[A]].getContent.asInstanceOf[B]
        case _ => return null.asInstanceOf[B]
      };
    }

  def main(args: Array[String]): Unit = {
    // Task1 ------
    println("Task1:")
    val task1: Container[String] = new Container("SomeContainer")
    task1.applyFunction(a => a + a)
    println(task1.getContent)


    // Task2 ------
    println("Task2:")
    val no: No = new No()
    println(no.isInstanceOf[Maybe[_]])
    val yes: Yes[String] = new Yes("y")
    println(yes.isInstanceOf[Maybe[_]])

    // Task3 ------
    println("Task3:")
    val task3no: Task3[No] = new Task3[No](new No())
    task3no.applyFunction(a => a)
    println(task3no.getContent)

    val task3yes: Task3[Yes[String]] = new Task3[Yes[String]](new Yes("Hello"))
    task3yes.applyFunction(a => new Yes(a.getContent + a.getContent))
    println(task3yes.getContent.getContent)

    // Task4 ------
    println("Task4:")
    val task4no: Task4[No] = new Task4[No](new No())
    println(task4no.getOrElse)

    val task4yes: Task4[Yes[String]] = new Task4[Yes[String]](new Yes("Hello"))
    println(task4yes.getOrElse)

  }

}