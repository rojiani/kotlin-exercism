/**
 * BaseConverter
 *
 * http://exercism.io/exercises/kotlin/all-your-base/readme
 * http://exercism.io/tracks/kotlin/exercises/all-your-base
 * http://exercism.io/submissions/4982a5d703a64ee39d2aeaeaf0ac4ad3
 *
 * @author nrojiani
 * @date 10/1/17
 */
class BaseConverter(private var base: Int, private var digits: IntArray) {

    init {
        validateInput(base, digits)
        this.base = base
        this.digits = digits
    }

    private val decimalValue by lazy {
        digits.reversed()
                .foldIndexed(0) { power, acc, digit ->
                    val positionalValue = base.exp(power) * digit
                    acc + positionalValue
                }
    }

    fun convertToBase(newBase: Int): IntArray {
        require(newBase >= 2) { "Bases must be at least 2." }

        var remainder = decimalValue
        val positionValues = newBasePositionValues(decimalValue, newBase)
        val resultDigits = IntArray(positionValues.size, { 0 })

        return positionValues.entries.reversed().fold(resultDigits) { acc, (index, positionalValue) ->
            while (remainder > 0 && remainder - positionalValue >= 0) {
                remainder -= positionalValue
                acc[index]++
            }
            acc
        }.reversedArray()
    }

    /* Position => Position Value, e.g., for base 2: {0 to 1, 1 to 2, 2 to 4, 3 to 8} */
    private fun newBasePositionValues(decimalValue: Int, newBase: Int): Map<Int, Int> {
        val sequence = generateSequence(0) { (it + 1).takeIf { newBase.exp(it) < decimalValue } }
        val positions = (sequence.first()..sequence.last())
        return positions.map { index ->
            index to newBase.exp(index)
        }.toMap()
    }

    private fun validateInput(base: Int, digits: IntArray) {
        require(base >= 2) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits.first() != 0 || digits.size == 1) { "Digits may not contain leading zeros." }
        require(digits.all { it >= 0 }) { "Digits may not be negative." }
        require(digits.all { it < base }) { "All digits must be strictly less than the base." }
    }

    private infix fun Int.exp(power: Int): Int = Math.pow(this.toDouble(), power.toDouble()).toInt()
}
