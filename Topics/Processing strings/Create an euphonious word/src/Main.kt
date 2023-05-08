const val VOWELS = "aeiouy"
fun main() {
    var addLetters = 0
    var consonants = 0
    var vowels = 0
    readln().forEach {
        if (it in VOWELS) {
            vowels++
            if (vowels == 3) {
                addLetters++
                vowels = 1
            }
            consonants = 0
        } else {
            consonants++
            if (consonants == 3) {
                addLetters++
                consonants = 1
            }
            vowels = 0
        }
    }
    addLetters.let(::println)
}