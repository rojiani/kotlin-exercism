/**
 * http://exercism.io/exercises/kotlin/anagram/readme
 * http://exercism.io/submissions/bf744ff9b85b45bd8c076a6f214957f4
 */
class Anagram(private val word: String) {

    fun match(possibleAnagrams: List<String>): List<String> =
        possibleAnagrams
                .filter { it.length == word.length }
                .filterNot { it.equals(word, ignoreCase = true) }
                .filter { it.sortedChars() == word.sortedChars() }

    private fun String.sortedChars(): List<Char> = this.toLowerCase().toCharArray().sorted()
}


