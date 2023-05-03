fun main() {
    val range1 = readln().toInt()
    val range2 = readln().toInt()

    var sum = 0
    for (num in range1..range2) {
        sum += num
    }

    println(sum)
}