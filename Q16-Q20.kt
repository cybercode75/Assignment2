// 16. Apply
class Window(var width: Int = 0, var height: Int = 0)
val win = Window().apply {
    width = 1920
    height = 1080
}

// 17. Let
val input: String? = "Kotlin"
input?.let { println(it.length) }

// 18. Suspend
import kotlinx.coroutines.*
suspend fun fetchWeather(): String {
    delay(1000)
    return "Sunny"
}

// 19. Launch
fun main() = runBlocking {
    launch {
        println("Background task finished")
    }
}

// 20. Async
fun main() = runBlocking {
    val result = async { 5 + 5 }
    println(result.await())
}
