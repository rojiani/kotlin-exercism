/**
 * SpiralMatrix
 *
 * http://exercism.io/exercises/kotlin/spiral-matrix/readme
 * http://exercism.io/tracks/kotlin/exercises/spiral-matrix
 * http://exercism.io/submissions/fa010720c137493297757ab5ae329d32
 *
 * @author nrojiani
 * @date 8/24/17
 */
object SpiralMatrix {

    /* Counter for next number to write */
    private var count = 1

    fun ofSize(n: Int): Array<IntArray> {
        val matrix = Array(n, { IntArray(n) })
        var indices = (0 until n)
        count = 1

        while (!indices.isEmpty()) {
            paintEdges(matrix, indices)
            indices = indices.dropFirstAndLast()
        }

        return matrix
    }

    /**
     * Paints the outermost edges.
     * If `indexRange` is provided, it will paint the outermost edges of the inner square matrix
     * specified by the indices.
     */
    private fun paintEdges(matrix: Array<IntArray>, indexRange: IntRange = (0 until matrix.size)) {
        val first = indexRange.first
        val last = indexRange.last
        /* top row (->) */
        (first..last)
                .forEach { matrix[first][it] = count++ }

        /* rightmost column (down) */
        (first + 1..last)
                .forEach { matrix[it][last] = count++ }

        /* bottom row (<-) */
        (last - 1 downTo first)
                .forEach { matrix[last][it] = count++ }

        /* leftmost column (up) */
        (last - 1 downTo first + 1)
                .forEach { matrix[it][first] = count++ }
    }
}

fun IntRange.dropFirstAndLast(): IntRange {
    val elements = this.drop(1).dropLast(1)
    return when {
        elements.isEmpty() -> IntRange.EMPTY
        else -> IntRange(elements.first(), elements.last())
    }
}