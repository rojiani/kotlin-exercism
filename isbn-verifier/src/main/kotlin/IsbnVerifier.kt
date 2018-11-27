/**
 * https://exercism.io/my/solutions/79f7a55d76154b5bba151554aa4a8e63
 */
class IsbnVerifier {

    fun isValid(isbn: String): Boolean {
        /* Length should be 13 with dashes, or 10 without */
        if (isbn.length != 10 && isbn.length != 13) return false

        return try {
            isbn.run(::parseDigits)
                .run(::hasValidChecksum)
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun hasValidChecksum(isbnDigits: List<Int>): Boolean =
        (isbnDigits zip (10 downTo 1)).sumBy { (digit, multiplier) ->
            digit * multiplier
        } % 11 == 0

    /**
     * Parse the digits from the ISBN. If the check 'digit' is X,
     * it is converted to 10.
     * @throws IllegalArgumentException if the ISBN is not valid
     */
    private fun parseDigits(isbn: String): List<Int> = isbn.foldIndexed(emptyList()) { i, acc, char ->
        when {
            char.isDigit() -> acc + char.toString().toInt()
            i == isbn.lastIndex && char == 'X' -> acc + 10
            char == '-' -> acc
            else -> throw IllegalArgumentException("Invalid ISBN")
        }
    }
}

