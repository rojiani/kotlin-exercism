/**
 * CollatzCalculator
 *
 * http://exercism.io/exercises/kotlin/collatz-conjecture/readme
 * http://exercism.io/tracks/kotlin/exercises/collatz-conjecture
 * http://exercism.io/submissions/1b2f5438e75c45cba4536e0cfb599d0d
 *
 * Other submissions:
 * http://exercism.io/submissions/78becd831c564089a298eea6f484a508 -> uses buildSequence()
 * http://exercism.io/submissions/5aa451390b834667bef0954bd81f8087 -> clean, simple solution
 *
 * @author nrojiani
 * @date 8/20/17
 */
object CollatzCalculator {

    fun computeStepCount(n: Int): Int {
        require(n > 0) { "Only natural numbers are allowed" }

        return computeStepCount(n, 0)
    }

    private tailrec fun computeStepCount(n: Int, count: Int): Int =
        when {
            n == 1     -> count
            n.isEven() -> computeStepCount(n / 2, count + 1)
            else       -> computeStepCount(3 * n + 1, count + 1)
        }
}

fun Int.isEven() = this % 2 == 0
