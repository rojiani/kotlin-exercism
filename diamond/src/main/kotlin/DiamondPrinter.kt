/**
 * DiamondPrinter
 *
 * http://exercism.io/exercises/kotlin/diamond/readme
 * http://exercism.io/tracks/kotlin/exercises/diamond
 * http://exercism.io/submissions/5464a74d136a485abac00581d1d32d09
 */
class DiamondPrinter {

    private val ALPHABET = ('A'..'Z')

    fun printToList(letter: Char): List<String> {
        if (letter == 'A')
            return listOf("A")

        val letterIdx = ALPHABET.indexOf(letter)
        val rowWidth = (letterIdx * 2) + 1

        val above: List<String> = ('A' until letter)
                .foldIndexed(emptyList()) { index, acc, c ->

                    val endSpacesWidth = letterIdx - index
                    val endSpaces = spaces(endSpacesWidth)

                    if (index == 0) {
                        acc + (endSpaces + c + endSpaces)
                    } else {
                        val middleSpacesWidth = rowWidth - (endSpacesWidth * 2) - 2
                        val middleSpaces = spaces(middleSpacesWidth)
                        acc + (endSpaces + c + middleSpaces + c + endSpaces)
                    }

                }

        val below = above.reversed()
        val middle = letter + spaces(rowWidth - 2) + letter

        return above + middle + below
    }

    private fun spaces(n: Int): String = " ".repeat(n)
}
