fun main() = run {
    val num1 = readln().toInt()
    val num2 = readln().toInt()
    "%d plus %d equals %d".format(num1, num2, num1 + num2)
}.let(::println)