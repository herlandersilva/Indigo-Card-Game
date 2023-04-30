import kotlin.math.abs

fun main() {
    val (x1, y1) = readln().split(' ')
    val (x2, y2) = readln().split(' ')

    if (
        x1.toInt() == x2.toInt()
        || y1.toInt() == y2.toInt()
        || (abs(x1.toInt() - y2.toInt()) == abs(x2.toInt() - y1.toInt()))
        || (
                x1.toInt() < y1.toInt() && x2.toInt() < y2.toInt()
                && abs(x1.toInt() - y1.toInt()) == abs(x2.toInt() - y2.toInt())
           )
        ) {
        println("YES")
    } else {
        println("NO")
    }
/*    println(x1)*/
/*    println(x2)*/
/*    println(y1)*/
/*    println(y2)*/
/*    println(abs(x1.toInt() - y2.toInt()))*/
/*    println(abs(x2.toInt() - y1.toInt()))*/
}
