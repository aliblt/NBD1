object run2 {

  def matchDay(x: String): String = x match {
    case "Monday" => "Work"
    case "Tuesday" => "Work"
    case "Wednesday" => "Work"
    case "Thursday" => "Work"
    case "Friday" => "Work"
    case "Saturday" => "Weekend"
    case "Sunday" => "Weekend"
    case _ => "No Such Day"
  }

  class BankAccount( var balance: Double) {

    def this(){
      this(0)
    }

    def deposit( money: Double ) ={
      balance += money
    }

    def withdraw( money: Double ) = {
      balance -= money
    }

    def currentBalance() = balance
  }

  class Person( var firstName: String, var lastName: String){
    def getFirstName: String = firstName
    def getLastName: String = lastName
  }

  def greetPerson(p: Person): String = p match {
    case p if p.getLastName.equals("Kenobi") => "Hello There!"
    case p if p.getLastName.equals("Grievous") => "General Kenobi!"
    case _ => "Just Hi!"
  }

  def main(args: Array[String]): Unit = {
    // Task 1 - Day matching
    println(matchDay("Tuesday"))
    println(matchDay("Saturday"))
    println(matchDay("Samiday"))
    println()

    // Task 2 - Bank account
    val acc1 = new BankAccount(20)
    println("initial balance: " + acc1.currentBalance())
    acc1.deposit(15.5)
    println("after deposit balance: " + acc1.currentBalance())
    acc1.withdraw(25.3)
    println("after withdraw balance: " + acc1.currentBalance())
    println()

    val acc2 = new BankAccount()
    println("Empty account: " + acc2.currentBalance())

    // Task 3 - greeting
    val p1 = new Person("Obi-Wan", "Kenobi")
    val p2 = new Person("General", "Grievous")
    val p3 = new Person("Darth", "Vader")

    println(greetPerson(p1))
    println(greetPerson(p2))
    println(greetPerson(p3))
    println()


  }


}
