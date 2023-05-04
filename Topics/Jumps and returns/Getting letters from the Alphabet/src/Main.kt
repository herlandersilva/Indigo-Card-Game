fun main() = readln().take(1).run {
    "abcdefghijklmnopqrstuvwxyz".forEach {
        if (this[0] == it) return@run
        it.let(::print)
    }
}