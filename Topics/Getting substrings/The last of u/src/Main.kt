fun main() {
    val string = readln()
    // write here
    string
        .replaceAfterLast(
            "u",
            string
                .substringAfterLast("u")
                .uppercase()
        )
        .let(::println)
}