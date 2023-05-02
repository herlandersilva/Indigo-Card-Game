package indigo

class IndigoCardGame() {
    private var deck = `take a deck`()

    fun `reset, shuffle, get and exit`() = this.menu()

    private fun menu() {
        while (this.actionMenu()) {}
    }
    private fun actionMenu(): Boolean {
        when (Util.ask("Choose an action (reset, shuffle, get, exit):")) {
            "reset" -> reset()
            "shuffle" -> shuffle()
            "get" -> getCards(Util.ask("Number of cards:"))
            "exit" -> return exit()
            else -> "Wrong action.".let(::println)
        }
        return true
    }

    private fun reset() {
        deck = `take a deck`()
        "Card deck is reset.".let(::println)
    }

    private fun shuffle() {
        deck.shuffle()
        "Card deck is shuffled.".let(::println)
    }

    private fun getCards(numOfCards: String) {
        try {
            val nOfCards = numOfCards.toInt()
            if (nOfCards !in 1..52) {
                "Invalid number of cards.".let(::println)
            } else if (deck.size < nOfCards) {
                "The remaining cards are insufficient to meet the request.".let(::println)
            } else {
                val takeCards = deck.take(nOfCards)
                deck.removeAll(takeCards)
                showTheDeck(takeCards.toMutableList())
            }
        } catch (_: IllegalArgumentException) {
            "Invalid number of cards.".let(::println)
        }
    }

    private fun showTheDeck(_deck: MutableList<Card> = deck) {
        _deck.joinToString(
            separator = " ",
            transform = { card: Card -> card.toString() }
        ).let(::println)
    }

    private fun exit(): Boolean {
        "Bye".let(::println)
        return false
    }
}



