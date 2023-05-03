package indigo

import kotlin.random.Random

const val NUMBER_OF_DECK_CARDS = 52
const val NUMBER_OF_CARDS_TO_DEAL = 6
const val MESSAGE_OF_CARDS_ON_THE_TABLE = "%d cards on the table, and the top card is %s"

class IndigoCardGame {
    private var deck = `take a deck`()
    private var cardsOnTheTable: MutableList<Card> = mutableListOf()
    private var cardsOfHuman: MutableList<Card> = mutableListOf()
    private var cardsOfComputer: MutableList<Card> = mutableListOf()

    fun `reset, shuffle, get and exit`() = this.menu()

    fun `play indigo card game`() = this.startTheGame()

    private fun startTheGame() {
        var humanPlaying: Boolean? = null

        "Indigo Card Game".let(::println)

        var answer = ""
        while (humanPlaying == null) {
            when (answer.uppercase()) {
                "YES" -> humanPlaying = true
                "NO" -> humanPlaying = false
                else -> answer = Util.ask("Play first?")
            }
        }

        shuffle()

        this.cardsOnTheTable.addAll(getCards("4"))
        "Initial cards on the table: "
            .let(::print)
            .also { showTheCards(this.cardsOnTheTable) }

        dealCards(this.cardsOfHuman)
        dealCards(this.cardsOfComputer)

        while (this.cardsOnTheTable.size != NUMBER_OF_DECK_CARDS) {
            humanPlaying = if (humanPlaying == true) {
                "".let(::println).also { showCardOnTable() }

                "Cards in hand: "
                    .let(::print)
                    .also { showTheCards(this.cardsOfHuman, true) }

                var choice = ""
                while (!correctChoice(choice))
                    choice = Util.ask("Choose a card to play (1-%d):"
                        .format(this.cardsOfHuman.size))

                if (choice == "exit") {
                    exit()
                    return
                }

                val removeCard = choice.toInt() - 1
                this.cardsOnTheTable.add(this.cardsOfHuman[removeCard])
                this.cardsOfHuman.removeAt(removeCard)

                false
            } else {
                "".let(::println).also { showCardOnTable() }

                val removeCard = Random.Default.nextInt(this.cardsOfComputer.size)

                "Computer plays %s"
                    .format(this.cardsOfComputer[removeCard])
                    .let(::println)

                this.cardsOnTheTable.add(this.cardsOfComputer[removeCard])
                this.cardsOfComputer.removeAt(removeCard)

                true
            }

            if (this.deck.size >= NUMBER_OF_CARDS_TO_DEAL) {
                if (this.cardsOfHuman.isEmpty()) {
                    dealCards(this.cardsOfHuman)
                }
                if (this.cardsOfComputer.isEmpty()) {
                    dealCards(this.cardsOfComputer)
                }
            }
        }

        "".let(::println).also { showCardOnTable() }
        exit()
    }

    private fun showCardOnTable() {
        MESSAGE_OF_CARDS_ON_THE_TABLE
            .format(this.cardsOnTheTable.size, this.cardsOnTheTable.last())
            .let(::println)
    }

    private fun correctChoice(choice: String): Boolean {
        if (choice == "exit") return true
        return choice in ("1"..this.cardsOfHuman.size.toString())
    }

    private fun dealCards(dealToWhom: MutableList<Card>) {
        dealToWhom.addAll(getCards(NUMBER_OF_CARDS_TO_DEAL.toString()))
    }

    private fun menu() {
        while (this.actionMenu()) {}
    }

    private fun actionMenu(): Boolean {
        when (Util.ask("Choose an action (reset, shuffle, get, exit):")) {
            "reset" -> reset()
            "shuffle" -> shuffle(true)
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

    private fun shuffle(printMessage: Boolean = false) {
        deck.shuffle()
        if (printMessage) "Card deck is shuffled.".let(::println)
    }

    private fun getCards(numOfCards: String, print: Boolean = false): MutableList<Card> {
        try {
            val nOfCards = numOfCards.toInt()
            if (nOfCards !in 1..52) {
                "Invalid number of cards.".let(::println)
            } else if (deck.size < nOfCards) {
                "The remaining cards are insufficient to meet the request.".let(::println)
            } else {
                val takeCards = deck.take(nOfCards).toMutableList()
                deck.removeAll(takeCards)
                if (print)
                    showTheCards(takeCards)
                return takeCards
            }
        } catch (_: IllegalArgumentException) {
            "Invalid number of cards.".let(::println)
        }
        return mutableListOf()
    }

    private fun showTheCards(cards: MutableList<Card> = deck, makeChoices: Boolean = false) {
        cards
            .mapIndexed { index: Int, card: Card ->
                (if (makeChoices) "${index + 1})" else "")
                    .plus("$card")
            }
            .toMutableList()
            .joinToString(" ")
            .let(::println)
    }

    private fun exit(): Boolean {
        "Game Over".let(::println)
        return false
    }
}