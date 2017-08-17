/**
 * SumOfMultiples.kt
 *
 * http://exercism.io/exercises/kotlin/sum-of-multiples/readme
 * http://exercism.io/tracks/kotlin/exercises/sum-of-multiples
 * http://exercism.io/submissions/4c5c8288c5df4325b9a28e52508b062b
 *
 * @author nrojiani
 * @date 8/16/17
 */
object SumOfMultiples {
    fun sum(factors: Set<Int>, endExclusive: Int) =
            (1 until endExclusive).sumBy { n ->
                if (factors.any { n.isMultipleOf(it) }) n
                else 0
            }
}

fun Int.isMultipleOf(n: Int) = this % n == 0
