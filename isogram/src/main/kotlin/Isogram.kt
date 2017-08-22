package Isogram

/**
 * Isogram
 *
 * http://exercism.io/exercises/kotlin/isogram/readme
 * http://exercism.io/tracks/kotlin/exercises/isogram
 * http://exercism.io/tracks/kotlin/exercises/isogram
 *
 * @author nrojiani
 * @date 8/21/17
 */
fun isIsogram(input: String): Boolean = letterFrequencies(input).values.none { it > 1 }

fun letterFrequencies(input: String): Map<Char, Int> =
        input.filter { it.isLetter() }
                .toLowerCase()
                .groupingBy { it }
                .eachCount()

