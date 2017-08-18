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