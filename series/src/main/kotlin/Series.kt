/**
 * Series
 *
 * http://exercism.io/exercises/kotlin/series/readme
 * http://exercism.io/tracks/kotlin/exercises/series
 *
 * @author nrojiani
 * @date 8/29/17
 */
object Series {

    fun slices(sz: Int, input: String): List<List<Int>> =
        (0..input.length - sz).foldIndexed(listOf()) { index, acc, _ ->
            val sliceRange = (index until index + sz)
            acc.plusElement(input.slice(sliceRange).map { it.toDigit() })
        }

}

// map to int, not unicode value.
fun Char.toDigit() = this.toString().toInt()