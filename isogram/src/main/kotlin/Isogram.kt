package Isogram

/**
 * Isogram
 *
 * http://exercism.io/exercises/kotlin/isogram/readme
 * http://exercism.io/tracks/kotlin/exercises/isogram
 * http://exercism.io/submissions/4cf7aff9f46f4fd5b3b01d0a53b23981
 *
 * @author nrojiani
 * @date 8/21/17
 */

fun isIsogram(input: String): Boolean {
    return letterFrequencies(input).values.none { it > 1 }
}


fun letterFrequencies(input: String): Map<Char, Int> {
    val map: MutableMap<Char, Int> = mutableMapOf()
    input.filter { it.isLetter() }
            .map { it.toLowerCase() }
            .forEach { ch ->
                    map.put(ch, map.getOrDefault(ch, 0) + 1)
            }
    return map
}