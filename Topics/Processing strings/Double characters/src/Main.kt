fun main() = readln()
    .let {
        (it zip it)
            .joinToString("") {
                pair ->
                pair.first.toString() + pair.second.toString()
            }
    }
    .let(::println)
