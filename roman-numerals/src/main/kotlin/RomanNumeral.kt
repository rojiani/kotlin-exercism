/**
 * RomanNumeral
 *
 * http://exercism.io/exercises/kotlin/roman-numerals/readme
 * http://exercism.io/tracks/kotlin/exercises/roman-numerals
 * http://exercism.io/submissions/6b437e269e4247418ef446e8492a032d
 *
 * @author nrojiani
 * @date 8/30/17
 */
object RomanNumeral {

    private val romanToArabic = mapOf(
               1 to "I",
               4 to "IV",
               5 to "V",
               9 to "IX",
              10 to "X",
              40 to "XL",
              50 to "L",
              90 to "XC",
             100 to "C",
             400 to "CD",
             500 to "D",
             900 to "CM",
            1000 to "M"
    )

    fun value(n: Int, roman: String = ""): String =
        when (n) {
            0 -> ""
            in romanToArabic -> roman + romanToArabic[n]
            else -> {
                val nextLargest = romanToArabic.keys.filter { it < n }.last()
                roman + romanToArabic[nextLargest] + value(n - nextLargest)
            }
        }

}