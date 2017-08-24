/**
 * WordCount
 *
 * http://exercism.io/exercises/kotlin/word-count/readme
 * http://exercism.io/tracks/kotlin/exercises/word-count
 *
 * @author nrojiani
 * @date 8/24/17
 */
object WordCount {
    fun phrase(input: String): Map<String, Int> =
            sanitize(input)
                    .groupingBy { it.toLowerCase() }
                    .eachCount()

    private fun sanitize(input: String): List<String> =
            input.split(" ")
                    .map { word ->
                        word.filter { it.isPermitted() } }
                    .filterNot { it.isBlank() }

    private val apostrophe: Char = '\''
    private fun Char.isPermitted() = this.isLetterOrDigit() || this == apostrophe
}