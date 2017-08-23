/**
 * DNA
 *
 * http://exercism.io/exercises/kotlin/nucleotide-count
 *
 * @author nrojiani
 * @date 8/23/17
 */
data class DNA(val dna: String) {

    private val NUCLEOTIDES = setOf('A', 'C', 'G', 'T')


    init {
        require(dna.all { it.isDnaNucleotide }) { "Invalid input: $dna" }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            val counts = NUCLEOTIDES.map { it to 0 }.toMap()
            return dna.groupingBy { it }.eachCountTo(counts.toMutableMap())
        }

    fun count(nucleotide: Char): Int {
        require(nucleotide.isDnaNucleotide) { "Invalid input: $nucleotide" }
        return nucleotideCounts.getOrDefault(nucleotide, 0)
    }

    private val Char.isDnaNucleotide: Boolean
        get() = this in NUCLEOTIDES
}
