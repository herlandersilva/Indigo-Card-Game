fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    var p = 1L
    (a until b).forEach { p *= it.toLong() }
    println(p)
}