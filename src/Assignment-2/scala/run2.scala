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

  def main(args: Array[String]): Unit = {
    // Task 1 - Day matching
    println(matchDay("Tuesday"))
    println(matchDay("Saturday"))
    println(matchDay("Samiday"))
  }


}
