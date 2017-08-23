/**
 * PigLatinSound
 *
 * @author nrojiani
 * @date 8/22/17
 */
enum class PigLatinSound(val sounds: Set<String>) {

    VOWEL_SOUND(Sounds.vowels union Sounds.twoLetterVowels),
    CONSONANT_SOUND(Sounds.consonants union Sounds.twoLetterConsonants union Sounds.threeLetterConsonants);

}

object Sounds {
    private val alphabet = ('a'..'z').map { it.toString() }.toSet()
    internal val vowels = setOf("a", "e", "i", "o", "u")
    internal val consonants = alphabet.subtract(vowels)
    internal val twoLetterVowels = setOf("yt", "xr")
    internal val twoLetterConsonants = setOf("ch", "qu", "th")
    internal val threeLetterConsonants = setOf("thr", "squ", "sch")
    internal val pigLatinSuffix = "ay"

}