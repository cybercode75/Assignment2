// 21. Map + Filter
data class Product(val name: String, val price: Double)
val inventory = listOf(
    Product("Laptop", 1000.0),
    Product("Mouse", 25.0),
    Product("Keyboard", 60.0)
)
val discounted = inventory.map { Product(it.name, it.price * 0.9) }
val filtered = discounted.filter { it.price > 50 }

// 22. Exhaustive State Machine
sealed class ScreenState2 {
    object Loading : ScreenState2()
    data class Success(val data: String) : ScreenState2()
    data class Error(val errorMsg: String) : ScreenState2()
}
fun renderUI(state: ScreenState2) {
    when (state) {
        is ScreenState2.Loading -> println("Loading...")
        is ScreenState2.Success -> println("Data: ${state.data}")
        is ScreenState2.Error -> println("Error: ${state.errorMsg}")
    }
}

// 23. Concurrent Downloader
suspend fun fetchUserData(): String {
    delay(1000)
    return "Alice"
}
suspend fun fetchAppConfig(): String {
    delay(2000)
    return "Dark Mode"
}
fun main() = runBlocking {
    val user = async { fetchUserData() }
    val config = async { fetchAppConfig() }
    println("${user.await()}, ${config.await()}")
}

// 24. Builder Pattern
fun buildFile(filename: String): java.io.File {
    return java.io.File(filename).apply {
        setReadable(true)
        setWritable(true)
    }.also {
        println("File $filename created")
    }
}

// 25. Polymorphic HOF
abstract class Shape {
    abstract fun calculateArea(): Double
}
class Circle(val r: Double) : Shape() {
    override fun calculateArea() = Math.PI * r * r
}
class Square(val s: Double) : Shape() {
    override fun calculateArea() = s * s
}
fun processShapes(shapes: List<Shape>, action: (Double) -> Unit) {
    for (shape in shapes) {
        action(shape.calculateArea())
    }
}
