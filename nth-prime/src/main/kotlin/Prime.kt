import kotlin.coroutines.experimental.buildSequence

/**
 * Prime
 *
 * http://exercism.io/exercises/kotlin/nth-prime/readme
 * http://exercism.io/tracks/kotlin/exercises/nth-prime
 * http://exercism.io/submissions/4fe7e2bbfe2f472a993acc33893b478a
 *
 * @author nrojiani
 * @date 8/20/17
 */
object Prime {

    private fun primes(): Sequence<Int> {
        return buildSequence {
            yieldAll(generateSequence(2) { it + 1 }
                    .filter { it.isPrime() })
        }
    }

    fun nth(n: Int): Int {
        require(n > 0) { "nth undefined for input: $n." }
        return primes().take(n).last()
    }

}

fun Int.isPrime(): Boolean {
    if (this <= 1)
        return false

    val sqrt = Math.sqrt(toDouble()).toInt()
    return (2..sqrt).all { this % it != 0 }
}
