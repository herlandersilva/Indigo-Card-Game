package indigo

enum class Suits(val descSuit: String = "", private val symbol: String = "", val hex: String = "", val utf8: String = "", val dec: String = "") {
    SPADES("Spades", "♠", "&#x2660", "U+2660", "9824"),
    DIAMONDS("Diamonds", "♦", "&#x2666", "U+2666", "9830"),
    HEARTS("Hearts", "♥", "&#x2665", "U+2665", "9829"),
    CLUBS("Clubs", "♣", "&#x2663", "U+2663", "9827");

    override fun toString(): String {
        return symbol
    }
}

enum class Ranks(private val rank: String = "", val descRank: String = "", val value: Int = -1, val term: String = "") {
    ACE("A", "Ás", 1, "aces"),
    TWO("2", "Two", 2, "deuces"),
    THREE("3", "Three", 3, "treys"),
    FOUR("4", "Four", 4),
    FIVE("5", "Five", 5),
    SIX("6", "Six", 6),
    SEVEN("7", "Seven", 7),
    EIGHT("8", "Eight", 8),
    NINE("9", "Nine", 9),
    TEN("10", "Ten", 10),
    JACK("J", "Jack", 11),
    QUEEN("Q", "Queen", 12),
    KING("K", "King", 13);

    override fun toString(): String {
        return rank
    }
}

fun `take a deck`(): MutableList<Card> {
    val deck = mutableListOf<Card>()
    with(deck) {
        for (suit in Suits.values().reversed())
            for (rank in Ranks.values().reversed())
                add(Card(rank, suit))
    }
    return deck
}