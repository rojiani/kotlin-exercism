package Acronym

/**
 * Acronym.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/acronym
 * http://exercism.io/submissions/067103a174474ff48182fc9075a11d4a
 *
 * @author nrojiani
 * @date 8/14/17
 */
fun generate(phrase: String): String =
        phrase.split(*arrayOf(" ", "-"))
                .fold("") { acc, word ->
                    acc + word.filterIndexed { i, ch ->
                        i == 0 || (ch.isUpperCase() && word[i - 1].isLowerCase())
                    }
                }.toUpperCase()
