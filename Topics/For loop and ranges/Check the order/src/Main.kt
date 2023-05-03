fun main() {
    generateSequence { readln().toInt() }
        .take(readln().toInt())
        .toList()
        .let { if (it == it.sorted()) "YES" else "NO" }
        .also(::println)
}
