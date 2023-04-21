package indigo

data class Cards(val ranks: Ranks, val suits: Suits) {
    override fun toString(): String {
        return ranks.rank
    }
}
