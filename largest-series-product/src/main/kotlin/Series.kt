/**
 * Series.kt
 *
 * http://exercism.io/exercises/kotlin/largest-series-product/readme
 * http://exercism.io/tracks/kotlin/exercises/largest-series-product
 * http://exercism.io/submissions/87cf9a2133c744b0bb4976172d2730be
 *
 * @author nrojiani
 * @date 8/17/17
 */
data class Series(private val input: String) {
    init {
        require(input.toList().all { it.isDigit() }) { "Input contains non-digit" }
    }

    /* Convert String to List<Int> */
    private val series: List<Int> by lazy(mode = LazyThreadSafetyMode.NONE) {
        input.toList().map { it.toString().toInt() }
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0) { "Span must be >= 0" }
        require(span <= input.length) { "Span must be <= the size of the input" }

        return (0..(series.size - span))
                .foldIndexed(0L) { index, maxProduct, _ ->

                    val spanProduct = series.slice(index until (index + span))
                            .fold(1.0) { spanProduct, spanElement ->
                                spanProduct * spanElement.toDouble()
                            }.toLong()

                    if (spanProduct > maxProduct) spanProduct else maxProduct

                }
    }
}