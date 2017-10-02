/**
 * MinesweeperBoard
 *
 * http://exercism.io/exercises/kotlin/minesweeper/readme
 * http://exercism.io/tracks/kotlin/exercises/minesweeper
 * http://exercism.io/submissions/2ef7fe0fe6724e739a64b84da0994ee7
 *
 * @author nrojiani
 * @date 10/01/2017
 */
typealias Board = List<List<Char>>
const val MINE = '*'

data class MinesweeperBoard(private val inputBoard: List<String>) {

    private val board: Board by lazy { boardAs2DList() }

    fun withNumbers(): List<String> {
        return board.foldIndexed(emptyList()) { i, acc, row ->
            acc + row.foldIndexed(emptyList<Char>()) { j, rowChars, _ ->
                if (board[i][j] == MINE) {
                    rowChars + MINE
                } else {
                    val mines = countMinesAround(Square(i, j))
                    val square = if (mines == 0) ' ' else mines.asDigit()
                    rowChars + square
                }
            }.joinToString("")
        }
    }

    private fun boardAs2DList(): Board = inputBoard.map { it.toList() }

    private fun countMinesAround(square: Square): Int =
        square.neighboringSquares(board).sumBy { (x, y) ->
            if (board[x][y] == MINE) 1 else 0
        }

    private fun Int.asDigit(): Char = if (this == 0) ' ' else this.toString().first()
}

data class Square(val x: Int, val y: Int) {
    fun neighboringSquares(board: Board): List<Square> =
            possibleNeighbors().filter { it.isOn(board) }

    private fun possibleNeighbors(): List<Square> =
            (x - 1..x + 1).fold(emptyList()) { acc, row ->
                acc + when (row) {
                    x    -> listOf(Square(row, y - 1), Square(row, y + 1))
                    else -> (y - 1..y + 1).map { col -> Square(row, col) }
                }
            }

    private fun isOn(board: Board): Boolean =
            x in (0..board.lastIndex) && y in (0..board[0].lastIndex)
}