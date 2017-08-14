package Pangrams

/**
 * Pangrams.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/pangram
 * http://exercism.io/submissions/fcb3faa0f1a34d8da91ff148174a5803
 *
 * @author nrojiani
 * @date 8/11/17
 */
fun isPangram(str: String): Boolean {
    val alphabet = ('a'..'z').toList()
    return str.fold(alphabet) { remainingLetters, ch ->
        remainingLetters - ch.toLowerCase()
    }.isEmpty()
}
