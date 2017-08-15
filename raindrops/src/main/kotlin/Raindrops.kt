package Raindrops

/**
 * Raindrops.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/raindrops
 * http://exercism.io/submissions/3ca34f368ec348e4b49265d92bec38aa
 *
 * @author nrojiani
 * @date 8/14/17
 */
fun convert(input: Int): String =
    buildString {
        if (input % 3 == 0) append("Pling")
        if (input % 5 == 0) append("Plang")
        if (input % 7 == 0) append("Plong")
        if (length == 0)    append(input)
    }
