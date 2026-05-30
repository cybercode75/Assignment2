
class BankAccount {
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        balance += amount
        println("Balance is now $balance")
    }
}
