import java.math.BigInteger

/**
 * Board.kt
 *
 * http://exercism.io/exercises/kotlin/grains/readme
 * http://exercism.io/tracks/kotlin/exercises/grains
 * http://exercism.io/submissions/3257e642eb984fb6a9b464a8cfcc6255
 *
 * @author nrojiani
 * @date 8/17/17
 */
object Board {
    private const val NUMBER_OF_SQUARES = 64

    fun getGrainCountForSquare(square: Int): BigInteger {
        require(square in (1..NUMBER_OF_SQUARES)) {
            "Only integers between 1 and 64 (inclusive) are allowed"
        }

        return BigInteger.valueOf(2).pow(square - 1)
    }

    /*
     * Given 2^0 + 2^1 + ... + 2^k = 2^(k+1) - 1
     * Note: Square number is one-indexed
     */
    fun getTotalGrainCount(): BigInteger =
            BigInteger.valueOf(2).pow(NUMBER_OF_SQUARES) - BigInteger.ONE
}