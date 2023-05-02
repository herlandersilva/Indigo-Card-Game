package indigo

data class Card(val rank: Ranks, val suit: Suits) {
    override fun toString(): String {
        return rank.toString() + suit.toString()
    }
}
