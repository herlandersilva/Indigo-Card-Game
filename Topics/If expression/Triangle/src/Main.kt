fun main() = IntArray(3)
    .map { readln().toInt() }
    .sorted()
    .run { if (get(0) + get(1) > get(2)) "YES" else "NO" }
    .let(::println)