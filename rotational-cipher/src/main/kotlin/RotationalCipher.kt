/**
 * RotationalCipher
 *
 * http://exercism.io/exercises/kotlin/rotational-cipher/readme
 * http://exercism.io/tracks/kotlin/exercises/rotational-cipher
 * http://exercism.io/submissions/9c20b61deec94b76bca5475089ee36fb
 *
 * @author nrojiani
 * @date 8/30/17
 */
data class RotationalCipher(private val shift: Int) {

    fun encode(input: String): String =
            input.fold("") { acc, ch ->
                acc + transpose(ch)
            }

    private fun transpose(char: Char): Char {

        var transposeChar: (Char, CharRange) -> Char = { c: Char, alphabet: CharRange ->
            alphabet.elementAt((alphabet.indexOf(c) + shift) % alphabet.count())
        }

        return when {
            char.isLowerCase() -> transposeChar(char, ('a'..'z'))
            char.isUpperCase() -> transposeChar(char, ('A'..'Z'))
            else -> char
        }
    }
}
