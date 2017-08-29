/**
 * PascalsTriangle
 *
 * http://exercism.io/exercises/kotlin/pascals-triangle/readme
 * http://exercism.io/tracks/kotlin/exercises/pascals-triangle
 * http://exercism.io/submissions/ee1260e1d76e406493f018ea1260f23a
 *
 * @author nrojiani
 * @date 8/28/17
 */
object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        require(rows >= 0) { "Number of rows must be >= 0" }

        /* Create List<IntArray> full of 1s */
        val triangle = List(rows + 1, { i -> IntArray(i, { 1 }) })

        (3..rows).forEach { i ->
            triangle[i].forEachIndexed { j, _->
                if (j != 0 && j != triangle[i].lastIndex) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
                }
            }
        }

        /* Convert List<IntArray> -> List<List<Int>> and drop empty 0th row */
        return triangle.map { it.toList() }.drop(1)
    }

}