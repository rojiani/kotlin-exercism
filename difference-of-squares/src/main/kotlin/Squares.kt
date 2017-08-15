/**
 * Squares.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/difference-of-squares
 * http://exercism.io/submissions/38457a64d4454b8d853e767bdcf76a5c
 *
 * @author nrojiani
 * @date 8/14/17
 */
data class Squares(val nth: Int) {
    private val range = (1..nth)

    fun squareOfSum() = range.squareOfSum()
    fun sumOfSquares() = range.sumOfSquares()
    fun difference() = squareOfSum() - sumOfSquares()
}

/* Extension Functions */
fun Int.squared(): Int = this * this

fun IntRange.squareOfSum(): Int = this.sum().squared()
fun IntRange.sumOfSquares(): Int = this.sumBy { it.squared() }

