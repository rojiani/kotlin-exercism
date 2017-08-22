/**
 * Matrix
 *
 * http://exercism.io/exercises/kotlin/saddle-points/readme
 * http://exercism.io/submissions/93ae3064c5eb4012aa150269b24f84aa
 *
 * @author nrojiani
 * @date 8/21/17
 */
data class Matrix(private val m: List<List<Int>>) {

     val saddlePoints: Set<MatrixCoordinate> by lazy(mode = LazyThreadSafetyMode.NONE) {
         calculateSaddlePoints()
     }

    private val rows: Int = m.size
    private val columns: Int = m[0].size

    private fun row(i: Int): List<Int> {
        require(i in 0..rows) { "Invalid row: $i" }
        return m[i]
    }

    private fun column(j: Int): List<Int> {
        require(j in 0..columns) { "Invalid column: $j" }
        return m.map { row -> row[j] }
    }

    private fun rowMax(i: Int): Int? = row(i).max()
    private fun columnMin(j: Int): Int? = column(j).min()

    private fun isSaddlePoint(i: Int, j: Int): Boolean =
            m[i][j] == rowMax(i) && m[i][j] == columnMin(j)

    private fun calculateSaddlePoints(): Set<MatrixCoordinate> =
        m.foldIndexed(emptySet()) { i, saddlePts, row ->

            saddlePts union row.foldIndexed(emptySet()) { j, rowSaddlePts, _ ->
                if (isSaddlePoint(i, j)) rowSaddlePts + MatrixCoordinate(i, j)
                else rowSaddlePts
            }

        }

}