// 11. Lambda
val square: (Int) -> Int = { it * it }

// 12. Higher-Order Function
fun executeTwice(action: () -> Unit) {
    action()
    action()
}

// 13. Filter
val evens = listOf(1, 2, 3, 4, 5).filter { it % 2 == 0 }

// 14. Map
val lengths = listOf("apple", "banana").map { it.length }

// 15. Extension Function
fun String.addExclamation(): String = this + "!"
