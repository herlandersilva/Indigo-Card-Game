fun main() = readln()
    .substringAfter("?")
    .split("&")
    .joinToString(separator = "\n") { s: String ->
        "%s : %s".format(
            s.split("=").first(),
            s.split("=").last().ifBlank { "not found" }
        )
    }
    .let {
        it.let(::println)
        "pass : (.*)(\n)?"
            .toRegex()
            .find(it)
            ?.groupValues
            ?.get(1)
            .let { pass ->
                if (!pass.isNullOrEmpty()) "password : %s".format(pass).let(::println)
            }
    }
