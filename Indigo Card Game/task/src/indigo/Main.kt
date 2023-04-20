package indigo

fun main() {
    println(Deck.ACE.CLUBS)
    Ranks.values().forEach { "%s ".format(it).let(::print) }
    println()
    Suits.values().forEach { "%s ".format(it).let(::print) }
    println()
    Suits.values().forEach {
        suit -> Ranks.values().forEach {
            rank -> "%s%s ".format(rank, suit).let(::print)
        }
    }
}