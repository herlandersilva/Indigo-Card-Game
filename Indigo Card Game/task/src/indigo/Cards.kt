package indigo

enum class Suits(val desc: String, val symbol: String, val hex: String? = "", val utf8: String? = "", val dec: String? = "") {
    SPADES("Spades", "♠", "&#x2660", "U+2660", "9824"),
    HEARTS("Hearts", "♥", "&#x2665", "U+2665", "9829"),
    DIAMONDS("Diamonds", "♦", "&#x2666", "U+2666", "9830"),
    CLUBS("Clubs", "♣", "&#x2663", "U+2663", "9827");

    override fun toString(): String {
        return symbol
    }
}


enum class Ranks(val rank: String, val desc: String, val value: Int, val term: String? = "") {
    RA("A", "Ás", 1, "aces"),
    R2("2", "Two", 2, "deuces"),
    R3("3", "Three", 3, "treys"),
    R4("4", "Four", 4),
    R5("5", "Five", 5),
    R6("6", "Six", 6),
    R7("7", "Seven", 7),
    R8("8", "Eight", 8),
    R9("9", "Nine", 9),
    R10("10", "Ten", 10),
    RJ("J", "Knave", 11),
    RQ("Q", "Queen", 12),
    RK("K", "Knight", 13);

    override fun toString(): String {
        return rank
    }
}

enum class Cards() {
}