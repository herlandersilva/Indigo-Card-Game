package indigo

import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.system.exitProcess

const val NUMBER_OF_CARDS_TO_DEAL = 6
const val MESSAGE_OF_CARDS_ON_THE_TABLE = "%d cards on the table, and the top card is %s"

class IndigoCardGame {
    private var deck = `take a deck`()
    private var cardsOnTheTable: MutableList<Card> = mutableListOf()
    private var cardsOfHuman: MutableList<Card> = mutableListOf()
    private var cardsOfComputer: MutableList<Card> = mutableListOf()
    private var scoreOfHuman = 0
    private var scoreOfComputer = 0
    private var humanHands: MutableList<Card> = mutableListOf()
    private var computerHands: MutableList<Card> = mutableListOf()
    private var humanLastWinnerHand by Delegates.notNull<Boolean>()

    fun `play indigo card game`() = this.playingTheGame()

    private fun playingTheGame() {
        "Indigo Card Game".let(::println)
        var humanPlaying = this.`human start playing?`()

        shuffle()

        this.cardsOnTheTable.addAll(getCards("4"))
        "Initial cards on the table: "
            .let(::print)
            .also { showTheCards(this.cardsOnTheTable) }

        dealCards(this.cardsOfHuman)
        dealCards(this.cardsOfComputer)

        lateinit var card: Card
        while (this.cardsOfHuman.isNotEmpty() || this.cardsOfComputer.isNotEmpty()) {
            humanPlaying = if (humanPlaying) {
                "".let(::println).also { showCardOnTable() }

                "Cards in hand: "
                    .let(::print)
                    .also { showTheCards(this.cardsOfHuman, true) }

                val choice = correctChoice()

                if (choice == "exit") exit()

                card = this.cardsOfHuman[choice.toInt() - 1]
                this.cardsOnTheTable.add(card)
                this.cardsOfHuman.remove(card)

                false
            } else {
                "".let(::println).also { showCardOnTable() }

                showTheCards(this.cardsOfComputer)
                card = choiceCardToComputer()

                this.cardsOnTheTable.add(card)
                this.cardsOfComputer.remove(card)

                "Computer plays %s"
                    .format(card)
                    .let(::println)
                true
            }

            checkHand(!humanPlaying, card)

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

        if (this.humanHands.size == this.computerHands.size)
            if (humanPlaying)
                this.scoreOfHuman += 3
            else
                this.scoreOfComputer += 3
        else if (this.humanHands.size > this.computerHands.size)
            this.scoreOfHuman += 3
        else
            this.scoreOfComputer += 3

        checkLastHand()
        exit()
    }

    private fun choiceCardToComputer(): Card {
        val cardTopOfTable: Card? = if (this.cardsOnTheTable.isNotEmpty()) this.cardsOnTheTable.last() else null

        return if (cardTopOfTable != null) {
            choiceCardByTableTopCard(cardTopOfTable)
        } else {
            randomCardByComputerHand()
        }
    }

    private fun choiceCardByTableTopCard(cardTopOfTable: Card): Card {
        var cardsSuits = this.cardsOfComputer
            .filter { card: Card -> card.suit == cardTopOfTable.suit }

        val cardsRanks = this.cardsOfComputer
            .filter { card: Card -> card.rank == cardTopOfTable.rank }

        val cards = maxOf(cardsSuits, cardsRanks, compareBy { it.size })

        return if (cards.isNotEmpty())
            cards[Random.Default.nextInt(cards.size)]
        else
            randomCardByComputerHand()
    }

    private fun randomCardByComputerHand(): Card {
        val cards = if (this.cardsOfComputer.groupBy { it.suit }.values.maxOf { it.size } > 1) {
            this.cardsOfComputer.groupBy { it.suit }
                .filter { it ->
                    it.value.size == this.cardsOfComputer.groupBy { it.suit }.values.maxOf { it.size }
                }
                .flatMap { it.value }
        } else {
            this.cardsOfComputer.groupBy { it.rank }
                .filter { it ->
                    it.value.size == this.cardsOfComputer.groupBy { it.rank }.values.maxOf { it.size }
                }
                .flatMap { it.value }
        }

        return cards[Random.Default.nextInt(cards.size)]
    }

    private fun checkLastHand() {
        if (this.humanLastWinnerHand) {
            this.humanHands.addAll(this.cardsOnTheTable)
            this.scoreOfHuman += calcOfScore()
        } else {
            this.computerHands.addAll(this.cardsOnTheTable)
            this.scoreOfComputer += calcOfScore()
        }
        scoreOfGame()
        this.cardsOnTheTable.clear()
    }

    private fun checkHand(humanPlayed: Boolean, card: Card) {
        if (this.cardsOnTheTable.size > 1) {
            val cardOnTopOfTable = this.cardsOnTheTable[this.cardsOnTheTable.size - 2]
            if (
                card.rank.value == cardOnTopOfTable.rank.value ||
                card.suit.descSuit == cardOnTopOfTable.suit.descSuit
                ) {
                val who = if (humanPlayed) {
                    this.humanHands.addAll(this.cardsOnTheTable)
                    this.scoreOfHuman += calcOfScore()
                    this.humanLastWinnerHand = true
                    "Player"
                } else {
                    this.computerHands.addAll(this.cardsOnTheTable)
                    this.scoreOfComputer += calcOfScore()
                    this.humanLastWinnerHand = false
                    "Computer"
                }
                this.cardsOnTheTable.clear()

                scoreOfGame(who)
            }
        }
        return
    }

    private fun calcOfScore() = cardsOnTheTable
        .count { card: Card -> card.rank.toString() in arrayOf("A","10","J","Q","K") }

    private fun scoreOfGame(winner: String? = null) {
        if (!winner.isNullOrBlank())
            "%s wins cards"
                .format(winner)
                .let(::println)

        "Score: Player %d - Computer %d"
            .format(this.scoreOfHuman, this.scoreOfComputer)
            .let(::println)

        "Cards: Player %d - Computer %d"
            .format(this.humanHands.size, this.computerHands.size)
            .let(::println)
    }

    private fun `human start playing?`(): Boolean =
        when (Util.ask("Play first?").uppercase()) {
            "YES" -> true
            "NO" -> false
            else -> `human start playing?`()
        }

    private fun showCardOnTable() =
        if (this.cardsOnTheTable.size > 0)
            MESSAGE_OF_CARDS_ON_THE_TABLE
                .format(this.cardsOnTheTable.size, this.cardsOnTheTable.last())
                .let(::println)
        else
            "No cards on the table".let(::println)

    private fun correctChoice(): String =
        when (val choice = Util.ask("Choose a card to play (1-%d):".format(this.cardsOfHuman.size))) {
            "exit", in ("1"..this.cardsOfHuman.size.toString()) -> choice
            else -> correctChoice()
        }

    private fun dealCards(dealToWhom: MutableList<Card>) = dealToWhom
        .addAll(getCards(NUMBER_OF_CARDS_TO_DEAL.toString()))

    private fun shuffle(printMessage: Boolean = false) = deck
        .shuffle()
        .also { if (printMessage) "Card deck is shuffled.".let(::println) }

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

    private fun showTheCards(cards: MutableList<Card> = deck, makeChoices: Boolean = false) = cards
        .mapIndexed { index: Int, card: Card ->
            (if (makeChoices) "${index + 1})" else "")
                .plus("$card")
        }
        .toMutableList()
        .joinToString(" ")
        .let(::println)

    private fun exit() {
        "Game Over".let(::println)
        exitProcess(0)
    }
}