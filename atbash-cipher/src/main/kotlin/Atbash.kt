/**
 * Atbash
 *
 * http://exercism.io/exercises/kotlin/atbash-cipher/readme
 * http://exercism.io/tracks/kotlin/exercises/atbash-cipher
 * http://exercism.io/submissions/d43da1d205284ce1a2f20ba8719a64f5
 *
 * Other solutions:
 * http://exercism.io/submissions/99517d9b95f240099876ad20b6dc0a0e
 *
 * @author nrojiani
 * @date 8/20/17
 */
object Atbash {

    private val alphabet = ('a'..'z').toList()

    enum class Transform(val map: Map<Char, Char>) {
        ENCODE(alphabet.zip(alphabet.reversed()).toMap()),
        DECODE(alphabet.reversed().zip(alphabet).toMap())
    }

    fun encode(input: String) = transform(input, Transform.ENCODE)
    fun decode(input: String) = transform(input, Transform.DECODE)

    /* Imperative solution */
    private fun transform(input: String, transformType: Transform): String {
        val stripped = input.filter { it.isLetterOrDigit() }
        return buildString {
            for ((i, ch) in stripped.withIndex()) {
                val coded = transformType.map.getOrDefault(ch.toLowerCase(), ch)
                val insertSpace = (transformType == Transform.ENCODE) && (i > 0) && (i % 5 == 0)

                if (insertSpace)
                    append(" ")
                append(coded)
            }
        }
    }

    /* FP Solution */
    private fun transformAlt(input: String, transformType: Transform): String {
        val stripped = input.filter { it.isLetterOrDigit() }
        return stripped.foldIndexed("") { i, acc, c ->

            val codedChar = transformType.map.getOrDefault(c.toLowerCase(), c)
            val insertSpace = (transformType == Transform.ENCODE) && (i > 0) && (i % 5 == 0)

            if (insertSpace)
                acc + ' ' + codedChar
            else
                acc + codedChar
        }
    }
}