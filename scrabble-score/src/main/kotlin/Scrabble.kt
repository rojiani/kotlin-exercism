package Scrabble
/**
 * Scrabble.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/scrabble-score
 * http://exercism.io/submissions/3472c74b45d840b5991635dcc0b5ce9f
 *
 * @author nrojiani
 * @date 8/14/17
 */
fun scoreWord(word: String): Int {
    return word.sumBy { letter ->
        valueOf(letter)
    }
}

private fun valueOf(letter: Char): Int =
    when (letter.toUpperCase()) {
        'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' ->  1
        'D', 'G'                                         ->  2
        'B', 'C', 'M', 'P'                               ->  3
        'F', 'H', 'V', 'W', 'Y'                          ->  4
        'K'                                              ->  5
        'J', 'X'                                         ->  8
        'Q', 'Z'                                         -> 10
        else                                             ->  0
    }
