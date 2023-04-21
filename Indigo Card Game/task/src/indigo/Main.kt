package indigo

fun main() {
    Ranks.ACE.CLUBS.toString().let(::println)

    /*
    Ranks.values().forEach { "%s ".format(it).let(::print) }
    println()
    Suits.values().forEach { "%s ".format(it).let(::print) }
    println()
    Suits.values().forEach {
        suit -> Ranks.values().forEach {
            rank -> "%s%s ".format(rank.rank, suit.symbol).let(::print)
        }
    }
    */
}