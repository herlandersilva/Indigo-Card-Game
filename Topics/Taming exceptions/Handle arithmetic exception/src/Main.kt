fun main() = try {
    (readln().toInt() / readln().toInt()).let(::println)
} catch (_: ArithmeticException) {
    "Division by zero, please fix the second argument!".let(::println)
}