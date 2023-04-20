package indigo

enum class Suits(val desc: String, val symbol: String, val hex: String? = "", val utf8: String? = "", val dec: String? = "") {
    SPADES("Spades", "♠", "&#x2660", "U+2660", "9824"),
    HEARTS("Hearts", "♥", "&#x2665", "U+2665", "9829"),
    DIAMONDS("Diamonds", "♦", "&#x2666", "U+2666", "9830"),
    CLUBS("Clubs", "♣", "&#x2663", "U+2663", "9827");

    lateinit var rank: Ranks
    override fun toString(): String {
        return rank.toString() + symbol
    }

    fun setRank(_rank: Ranks): Suits {
        this.rank = _rank
        return this
    }
}

enum class Ranks(val rank: String, val desc: String, val value: Int, val term: String? = "") {
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

enum class Deck(val SPADES: Suits, val HEARTS: Suits, val DIAMONDS: Suits, val CLUBS: Suits) {
    ACE(Suits.SPADES.setRank(Ranks.ACE), Suits.HEARTS.setRank(Ranks.ACE), Suits.DIAMONDS.setRank(Ranks.ACE), Suits.CLUBS.setRank(Ranks.ACE)),
    TWO(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    THREE(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    FOUR(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    FIVE(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    SIX(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    SEVEN(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    EIGHT(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    NINE(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    JACK(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    QUEEN(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS),
    KING(Suits.SPADES, Suits.HEARTS, Suits.DIAMONDS, Suits.CLUBS);

    fun Card() {
        this.name.length
    }
}