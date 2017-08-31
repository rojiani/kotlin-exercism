/**
 * RotationalCipher
 *
 * http://exercism.io/exercises/kotlin/rotational-cipher/readme
 * http://exercism.io/tracks/kotlin/exercises/rotational-cipher
 * http://exercism.io/submissions/c999b8cfcb214d889f2ec2b420b3d435
 *
 * @author nrojiani
 * @date 8/30/17
 */
data class RotationalCipher(private val shift: Int) {

    private val alphabet = ('a'..'z')

    fun encode(input: String): String = input.fold("") { acc, ch ->
        acc + when {
            ch.isLetter() -> transpose(ch)
            else -> ch
        }
    }

    private fun transpose(letter: Char): Char {
        var transposeLowerCase: (Char) -> Char = {
            alphabet.elementAt((alphabet.indexOf(it) + shift) % alphabet.count())
        }

        return when {
            letter.isLowerCase() -> transposeLowerCase(letter)
            letter.isUpperCase() -> transposeLowerCase(letter.toLowerCase()).toUpperCase()
            else -> throw IllegalArgumentException("Not a letter")
        }
    }
}