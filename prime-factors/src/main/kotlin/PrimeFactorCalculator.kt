/**
 * PrimeFactorCalculator
 *
 * http://exercism.io/exercises/kotlin/prime-factors/readme
 * http://exercism.io/tracks/kotlin/exercises/prime-factors
 * http://exercism.io/submissions/7358790b708f4843848d14838e6912cb
 *
 * @author nrojiani
 * @date 8/25/17
 */
object PrimeFactorCalculator {

    fun primeFactors(n: Long): List<Long> {
        if (n < 2) return emptyList()

        val primeFactors = mutableListOf<Long>()
        var remainder = n
        var i = 2L
        while (i <= remainder / i) {
            while (remainder % i == 0L) {
                primeFactors.add(i)
                remainder /= i
            }

            i++
        }

        if (remainder > 1)
            primeFactors.add(remainder)

        return primeFactors
    }

}
