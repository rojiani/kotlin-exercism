/**
 * DNA
 *
 * http://exercism.io/exercises/kotlin/nucleotide-count
 * http://exercism.io/tracks/kotlin/exercises/nucleotide-count
 * http://exercism.io/submissions/549463ea595749aa8afdedb56bfd4e87
 *
 *
 * Other solutions:
 * http://exercism.io/submissions/4d8b147d77e44531968dfc8a28a03486
 *
 * @author nrojiani
 * @date 8/23/17
 */
data class DNA(val dna: String) {

    private val dnaNucleotides = setOf('A', 'C', 'G', 'T')


    init {
        require(dna.all { it.isDnaNucleotide }) { "Invalid input: $dna" }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            val defaultCounts = dnaNucleotides.map { it to 0 }.toMap()
            return defaultCounts + dna.groupingBy { it }.eachCount()
        }

    fun count(nucleotide: Char): Int {
        require(nucleotide.isDnaNucleotide) { "Invalid input: $nucleotide" }
        return nucleotideCounts[nucleotide] ?: 0
    }

    private val Char.isDnaNucleotide: Boolean
        get() = this in dnaNucleotides
}
