/**
 * Bob
 *
 * http://exercism.io/exercises/kotlin/bob/readme
 * http://exercism.io/tracks/kotlin/exercises/bob
 *
 * @author nrojiani
 * @date 8/25/17
 */
object Bob {
    fun hey(words: String): String {
        return when {
            words.isBlank() -> "Fine. Be that way!"
            soundsAngry(words) -> "Whoa, chill out!"
            words.last() == '?' -> "Sure."
            else -> "Whatever."
        }
    }

    private fun soundsAngry(words: String): Boolean {
        val letters = words.filter { it.isLetter() }
        return letters.isNotEmpty() && letters.all { it.isUpperCase() }
    }
}