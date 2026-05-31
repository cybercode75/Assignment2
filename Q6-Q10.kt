// 6. Data Class
data class User(val id: Int, val username: String, val isActive: Boolean)

// 7. Copycat
val user1 = User(1, "Rik", true)
val user2 = user1.copy(isActive = false)

// 8. Singleton
object Database {
    fun connect() {
        println("Connected to DB")
    }
}

// 9. Companion Object
class IDGenerator {
    companion object {
        var currentId = 0
        fun getNextId(): Int {
            currentId++
            return currentId
        }
    }
}

// 10. Sealed Class
sealed class ScreenState
object Loading : ScreenState()
data class Success(val data: String) : ScreenState()
