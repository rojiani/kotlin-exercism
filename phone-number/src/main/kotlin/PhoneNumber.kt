/**
 * PhoneNumber
 *
 * http://exercism.io/exercises/kotlin/phone-number/readme
 * http://exercism.io/tracks/kotlin/exercises/phone-number
 * http://exercism.io/submissions/dd76882113cb4f979ac381f661128579
 *
 * @author nrojiani
 * @date 8/22/17
 */
data class PhoneNumber(val input: String) {

    val number: String by lazy { parseToTenDigitNumber() }
    val areaCode: String = number.take(3)
    private val exchangeCode = number.drop(3).take(3)
    private val subscriberNumber = number.takeLast(4)

    private fun parseToTenDigitNumber(): String {
        val digits = input.filter { it.isDigit() }

        if (digits.first() == '1') {
            require(digits.length == 11) { "Must be 11 digits including country code (1)" }
            return digits.drop(1)
        }

        require(digits.length == 10) { "Must be 10 digits excluding country code" }
        return digits
    }

    override fun toString(): String {
        return "($areaCode) $exchangeCode-$subscriberNumber"
    }
}