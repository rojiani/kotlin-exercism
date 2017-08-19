import kotlin.coroutines.experimental.buildSequence

/**
 * Sieve.kt
 *
 * http://exercism.io/exercises/kotlin/sieve/readme
 * http://exercism.io/tracks/kotlin/exercises/sieve
 * http://exercism.io/submissions/ddc8ba0eab324a04b31f57a9b2668ac5
 *
 * @author nrojiani
 * @date 8/18/17
 */
object Sieve {

    /*
     * Uses algorithm from https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    fun primesUpTo(n: Int): List<Int> {
        val bools = BooleanArray((0..n).count(), { i -> i >= 2 })

        (2..n.sqrt()).forEach { i ->
            if (bools[i]) {
                buildSequence {
                    yieldAll((i * i)..n step i)
                }.forEach { j ->
                    bools[j] = false
                }
            }
        }

        return bools.foldIndexed(emptyList()) { index, acc, b ->
            if (b) acc + index else acc
        }
    }
}


fun Int.sqrt(): Int = Math.sqrt(this.toDouble()).toInt()