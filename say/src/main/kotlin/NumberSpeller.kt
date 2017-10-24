/**
 * http://exercism.io/exercises/kotlin/say/readme
 * http://exercism.io/tracks/kotlin/exercises/say
 * Given a number from 0 to 999,999,999,999, spell out that number in English.
 */
class NumberSpeller {

    companion object {
        private val MAX_INPUT_VALUE = 1000000000000
    }

    private val singleDigits: Map<Int, String> = mapOf(
            1 to "one",
            2 to "two",
            3 to "three",
            4 to "four",
            5 to "five",
            6 to "six",
            7 to "seven",
            8 to "eight",
            9 to "nine"
    )

    private val tensPlace: Map<Int, String> = mapOf(
            2 to "twenty",
            3 to "thirty",
            4 to "forty",
            5 to "fifty",
            6 to "sixty",
            7 to "seventy",
            8 to "eighty",
            9 to "ninety"
    )

    fun say(n: Long): String {
        require(n >= 0) { "Input must be non-negative" }
        require(n < MAX_INPUT_VALUE) { "Input must be less than $MAX_INPUT_VALUE" }

        return when (n) {
            0L -> "zero"
            in 1..999 -> say0to999(n.toInt())
            else -> sayNumberOver1000(n)
        }
    }

    private fun say0to999(n: Int): String =
            when (n) {
                0 -> ""
                in 1..9 -> singleDigits[n]!!
                in 10..19 -> sayTeen(n)
                in 20..99 -> {
                    val tensMultiple: String = tensPlace[n / 10]!!
                    if (n.isMultipleOf(10)) {
                        "$tensMultiple"
                    } else {
                        val digit: String = singleDigits[n % 10]!!
                        "$tensMultiple-$digit"
                    }
                }
                in 100..999 -> {
                    val hundreds = singleDigits[n / 100]
                    val tensAndOnes = say0to999(n % 100)
                    "$hundreds hundred $tensAndOnes"
                }
                else -> throw IllegalArgumentException("value for say0to999 must be in range 0..999")
            }.trim()

    private fun sayNumberOver1000(number: Long): String {
        // 1234567890 -> ["1", "234", "567", "890"]
        val groupsOf3 = number.toGroupsOf3()

        // ["1", "234", "567", "890"] -> ["1 billion", "234 million", "567 thousand", "890"]
        val withScaleWords = addScaleWords(groupsOf3)

        // ["1 billion", "234 million", "567 thousand", "890"] -> result
        return withScaleWords.mapIndexed { index, string ->
            val tokens = string.split(" ")
            val amount = tokens.first().toInt()
            val amountWords = say0to999(amount)

            if (index != withScaleWords.lastIndex && amount != 0) {
                val scale = tokens.last()
                "$amountWords $scale"
            } else {
                amountWords
            }
        }.joinToString(" ").trim()
    }

    private fun sayTeen(n: Int): String =
            when (n) {
                10 -> "ten"
                11 -> "eleven"
                12 -> "twelve"
                15 -> "fifteen"
                18 -> "eighteen"
                else -> singleDigits[n % 10] + "teen"
            }

    private fun addScaleWords(groupsOf3: List<Int>): List<String> {
        val reversedGroups: List<String> = groupsOf3.reversed().map { it.toString() }
        val scaleWord = listOf("", "thousand", "million", "billion")
        return reversedGroups.mapIndexed { index, groupOf3 ->
            if (index > 0)
                "$groupOf3 ${scaleWord[index]}"
            else
                groupOf3
        }.reversed()
    }

    private fun Long.toGroupsOf3(): List<Int> {
        val digitString = this.toString()
        var groupsOf3: List<String> = emptyList()
        var remaining: String = digitString

        while (remaining.isNotBlank()) {
            groupsOf3 += remaining.takeLast(3)
            remaining = remaining.dropLast(3)
        }

        return groupsOf3.map { it.toInt() }.reversed()
    }

    private fun Int.isMultipleOf(n: Int): Boolean = this % n == 0
}
