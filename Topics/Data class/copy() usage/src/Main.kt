// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    // implement your code here
    val (height, length1, length2, width) = List(4) { readln().toInt() }

    val box1 = Box(height, length1, width)
    val box2 = box1.copy(length = length2)

    box1.let(::println)
    box2.let(::println)
}