package indigo

sealed class Suits(val descSuit: String = "", val symbol: String = "", val hex: String = "", val utf8: String = "", val dec: String = "") : Ranks() {
    object SPADES : Suits("Spades", "♠", "&#x2660", "U+2660", "9824") {

    }

    object HEARTS : Suits("Hearts", "♥", "&#x2665", "U+2665", "9829")
    object DIAMONDS : Suits("Diamonds", "♦", "&#x2666", "U+2666", "9830")
    object CLUBS : Suits("Clubs", "♣", "&#x2663", "U+2663", "9827") {
        override fun toString(): String {
            return rank + symbol
        }
    }

    fun card(): String {
        return this.toString()
    }
}

sealed class Ranks(val rank: String = "", val descRank: String = "", val value: Int = -1, val term: String = "") {

    object ACE : Ranks("A", "Ás", 1, "aces") {
        val SPADES = Suits.SPADES
        val HEARTS = Suits.HEARTS
        val DIAMONDS = Suits.DIAMONDS
        val CLUBS = Suits.CLUBS
    }
    object TWO : Ranks("2", "Two", 2, "deuces")
    object THREE : Ranks("3", "Three", 3, "treys")
    object FOUR : Ranks("4", "Four", 4)
    object FIVE : Ranks("5", "Five", 5)
    object SIX : Ranks("6", "Six", 6)
    object SEVEN : Ranks("7", "Seven", 7)
    object EIGHT : Ranks("8", "Eight", 8)
    object NINE : Ranks("9", "Nine", 9)
    object TEN : Ranks("10", "Ten", 10)
    object JACK : Ranks("J", "Jack", 11)
    object QUEEN : Ranks("Q", "Queen", 12)
    object KING : Ranks("K", "King", 13)
    object JOKER : Ranks("JK", "Joker", -1)

    //open val SPADES = Suits.SPADES
    //open val HEARTS = Suits.HEARTS
    //open val DIAMONDS = Suits.DIAMONDS
    //open val CLUBS = Suits.CLUBS

    override fun toString(): String {
        return rank
    }
}

enum class Deck {

    /*TWO(Suits.SPADES.setRank(Ranks.TWO), Suits.HEARTS.setRank(Ranks.TWO), Suits.DIAMONDS.setRank(Ranks.TWO), Suits.CLUBS.setRank(Ranks.TWO)),
    THREE(Suits.SPADES.setRank(Ranks.THREE), Suits.HEARTS.setRank(Ranks.THREE), Suits.DIAMONDS.setRank(Ranks.THREE), Suits.CLUBS.setRank(Ranks.THREE)),
    FOUR(Suits.SPADES.setRank(Ranks.FOUR), Suits.HEARTS.setRank(Ranks.FOUR), Suits.DIAMONDS.setRank(Ranks.FOUR), Suits.CLUBS.setRank(Ranks.FOUR)),
    FIVE(Suits.SPADES.setRank(Ranks.FIVE), Suits.HEARTS.setRank(Ranks.FIVE), Suits.DIAMONDS.setRank(Ranks.FIVE), Suits.CLUBS.setRank(Ranks.FIVE)),
    SIX(Suits.SPADES.setRank(Ranks.SIX), Suits.HEARTS.setRank(Ranks.SIX), Suits.DIAMONDS.setRank(Ranks.SIX), Suits.CLUBS.setRank(Ranks.SIX)),
    SEVEN(Suits.SPADES.setRank(Ranks.SEVEN), Suits.HEARTS.setRank(Ranks.SEVEN), Suits.DIAMONDS.setRank(Ranks.SEVEN), Suits.CLUBS.setRank(Ranks.SEVEN)),
    EIGHT(Suits.SPADES.setRank(Ranks.EIGHT), Suits.HEARTS.setRank(Ranks.EIGHT), Suits.DIAMONDS.setRank(Ranks.EIGHT), Suits.CLUBS.setRank(Ranks.EIGHT)),
    NINE(Suits.SPADES.setRank(Ranks.NINE), Suits.HEARTS.setRank(Ranks.NINE), Suits.DIAMONDS.setRank(Ranks.NINE), Suits.CLUBS.setRank(Ranks.NINE)),
    TEN(Suits.SPADES.setRank(Ranks.TEN), Suits.HEARTS.setRank(Ranks.TEN), Suits.DIAMONDS.setRank(Ranks.TEN), Suits.CLUBS.setRank(Ranks.TEN)),
    JACK(Suits.SPADES.setRank(Ranks.JACK), Suits.HEARTS.setRank(Ranks.JACK), Suits.DIAMONDS.setRank(Ranks.JACK), Suits.CLUBS.setRank(Ranks.JACK)),
    QUEEN(Suits.SPADES.setRank(Ranks.QUEEN), Suits.HEARTS.setRank(Ranks.QUEEN), Suits.DIAMONDS.setRank(Ranks.QUEEN), Suits.CLUBS.setRank(Ranks.QUEEN)),
    KING(Suits.SPADES.setRank(Ranks.KING), Suits.HEARTS.setRank(Ranks.KING), Suits.DIAMONDS.setRank(Ranks.KING), Suits.CLUBS.setRank(Ranks.KING))
    */;

    //open val SPADES = Suits.SPADES
    //open val HEARTS = Suits.HEARTS
    //open val DIAMONDS = Suits.DIAMONDS
    //open val CLUBS = Suits.CLUBS

    fun Card() {
        this.name
    }
}