package Isogram

/**
 * Isogram
 *
 * http://exercism.io/exercises/kotlin/isogram/readme
 * http://exercism.io/tracks/kotlin/exercises/isogram
 * http://exercism.io/submissions/15659c028b454fb2b31e67ae47fba7f3
 *
 * @author nrojiani
 * @date 8/21/17
 */

fun isIsogram(input: String): Boolean {
    return letterFrequencies(input).values.none { it > 1 }
}

fun letterFrequencies(input: String): Map<Char, Int> =
        input.filter { it.isLetter() }
                .map { it.toLowerCase() }
                .groupingBy { it }
                .eachCount()
