import kotlinx.coroutines.*

// 1. Cart Item
data class CartItem(val name: String, val price: Double, val quantity: Int)

// 2. Extension Function
fun List<CartItem>.calculateTotal(): Double {
    var sum = 0.0
    for (item in this) {
        sum += item.price * item.quantity
    }
    return sum
}

// 3. Sealed Class
sealed class CheckoutResult {
    object Processing : CheckoutResult()
    data class Success(val receiptId: String) : CheckoutResult()
    data class Failed(val reason: String) : CheckoutResult()
}

// 4. Payment Processor
object PaymentProcessor {
    suspend fun processPayment(cart: List<CartItem>): CheckoutResult {
        delay(2000) // pretend network call
        val total = cart.calculateTotal()
        return if (total > 1000) {
            CheckoutResult.Failed("Not enough money")
        } else {
            CheckoutResult.Success("TXN-${(1000..9999).random()}")
        }
    }
}

// 5. Main Function
fun main() = runBlocking {
    val cheapCart = listOf(CartItem("Book", 20.0, 2))
    val expensiveCart = listOf(CartItem("Laptop", 1200.0, 1))

    launch {
        val result = PaymentProcessor.processPayment(cheapCart)
        when (result) {
            is CheckoutResult.Success -> println("Cheap cart success: ${result.receiptId}")
            is CheckoutResult.Failed -> println("Cheap cart failed: ${result.reason}")
            is CheckoutResult.Processing -> println("Cheap cart processing...")
        }
    }

    launch {
        val result = PaymentProcessor.processPayment(expensiveCart)
        when (result) {
            is CheckoutResult.Success -> println("Expensive cart success: ${result.receiptId}")
            is CheckoutResult.Failed -> println("Expensive cart failed: ${result.reason}")
            is CheckoutResult.Processing -> println("Expensive cart processing...")
        }
    }
}
