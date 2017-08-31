/**
 * BeerSong
 *
 * http://exercism.io/exercises/kotlin/beer-song/readme
 * http://exercism.io/tracks/kotlin/exercises/beer-song
 *
 * @author nrojiani
 * @date 8/30/17
 */
object BeerSong {

    val lyrics: String by lazy { verses(99, 0) }

    fun verse(n: Int): String {
        require(n in (0..99)) { "Beer song only goes from 99 to 0" }

        val bottleOrBottles = if (n - 1 > 1) "bottles" else "bottle"

        return when (n) {
            in 2..99 -> "$n bottles of beer on the wall, $n bottles of beer.\nTake one down and pass it around, ${n-1} $bottleOrBottles of beer on the wall.\n"
            1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            else -> ""
        }
    }

    fun verses(startingBottles: Int, endingBottles: Int): String =
        (startingBottles downTo endingBottles).map { verse(it) }.joinToString(separator = "\n")
}