/**
 * Determine if a number is perfect, abundant, or deficient based on Nicomachus' (60 - 120 CE)
 * classification scheme for natural numbers.
 *
 * aliquot sum: s(n) of a positive integer n is the sum of all proper divisors of n, that is, all divisors of n other than n itself
 * Perfect: aliquot sum = number
 * Abundant: aliquot sum > number
 * Deficient: aliquot sum < number
 *
 * http://exercism.io/exercises/kotlin/perfect-numbers/readme
 * http://exercism.io/tracks/kotlin/exercises/perfect-numbers
 *
 */
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {
    require( n  >= 1 )  /* must be natural number */

    val aliquotSum = n.aliquotSum()

    return when {
        aliquotSum == n -> Classification.PERFECT
        aliquotSum > n  -> Classification.ABUNDANT
        else  -> Classification.DEFICIENT
    }
}

/*
 * Find all divisors of a natural number, n, including itself.
 */
fun Int.divisors() = (1..this).filter { it.isDivisorOf(this) }

fun Int.properDivisors() = this.divisors().dropLast(1)

fun Int.aliquotSum() = this.properDivisors().sum()

fun Int.isDivisorOf(n: Int): Boolean = (n.rem(this.toDouble())).compareTo(0.0) == 0