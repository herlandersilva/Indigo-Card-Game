package indigo

fun main() {
    Ranks.values().forEach { "%s ".format(it.rank).let(::print) }
    println()
    Suits.values().forEach { "%s ".format(it.symbol).let(::print) }
    println()
    Suits.values().forEach {
        suit -> Ranks.values().forEach {
            rank -> "%s%s ".format(rank.rank, suit.symbol).let(::print)
        }
    }
}