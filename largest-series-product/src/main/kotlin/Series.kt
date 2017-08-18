/**
 * Series.kt
 *
 * http://exercism.io/exercises/kotlin/largest-series-product/readme
 * http://exercism.io/tracks/kotlin/exercises/largest-series-product
 * http://exercism.io/submissions/12e3610fd70d49218336aebc42ed51db
 *
 * Other solutions:
 * http://exercism.io/submissions/3336fe86ad2b4d91806bd00db66c9016
 *
 * @author nrojiani
 * @date 8/17/17
 */
data class Series(private val input: String) {
    init {
        require(input.toList().all { it.isDigit() }) { "Input contains non-digit" }
    }

    private val series: List<Long> by lazy(mode = LazyThreadSafetyMode.NONE) {
        input.toList().map { it.toString().toLong() }
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0) { "Span must be >= 0" }
        require(span <= input.length) { "Span must be <= the size of the input" }

        return (0..(series.size - span))
                .foldIndexed(0L) { index, maxSpanProduct, _ ->

                    val spanProduct = series
                            .slice(index until (index + span))
                            .fold(1L) { product, n -> product * n }

                    maxOf(spanProduct, maxSpanProduct)
                }
    }
}