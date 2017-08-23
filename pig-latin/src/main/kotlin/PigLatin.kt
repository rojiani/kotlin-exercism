import PigLatinSound.*

/**
 * PigLatin
 *
 * http://exercism.io/exercises/kotlin/pig-latin/readme
 * http://exercism.io/tracks/kotlin/exercises/pig-latin
 * http://exercism.io/submissions/bef0be7e0bbf471b99823e6ee3203f6a
 *
 *
 * Other solutions:
 * http://exercism.io/submissions/697cf64d6377429c865280187fc1a251 -> Regex
 * http://exercism.io/submissions/cef99f1f325645c58c7b53de922cdbe9 -> Regex
 * http://exercism.io/submissions/466e67c4fe954d9994ef8dfef60f307e -> Regex
 * http://exercism.io/submissions/cb9adfa8f711476fa651467cd7b5ab12
 * http://exercism.io/submissions/5c2e7d26257f45d3a707e04cd289a74b -> Nice & Simple
 *
 * @author nrojiani
 * @date 8/21/17
 */
object PigLatin {


    fun translate(string: String): String {
        val words = string.toLowerCase().split(" ")
        return words.fold(emptyList<String>()) { acc, word ->
            if (wordBeginsWithSound(word, VOWEL_SOUND))
                acc + (word + "ay")
            else
                acc + convertConsonantWord(word)
        }.joinToString(separator = " ")
    }


    private fun wordBeginsWithSound(word: String, sound: PigLatinSound): Boolean =
        when (sound) {
            VOWEL_SOUND     -> VOWEL_SOUND.sounds.any { word.startsWith(it) }
            CONSONANT_SOUND -> CONSONANT_SOUND.sounds.any { word.startsWith(it) }
        }

    private fun beginningCharsToMove(word: String): Int =
            when {
                Sounds.threeLetterConsonants.any { word.startsWith(it) } -> 3
                Sounds.twoLetterConsonants.any { word.startsWith(it) }   -> 2
                Sounds.consonants.any { word.startsWith(it) }            -> 1
                else                                                     -> 0
            }

    private fun convertConsonantWord(word: String): String {
        val charsToMove = beginningCharsToMove(word)
        return word.drop(charsToMove) + word.take(charsToMove) + Sounds.pigLatinSuffix
    }
}

