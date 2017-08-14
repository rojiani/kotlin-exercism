/**
 * Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:
 * G -> C
 * C -> G
 * T -> A
 * A -> U
 *
 * http://exercism.io/tracks/kotlin/exercises/rna-transcription
 * http://exercism.io/submissions/110b6d640f1e451aaf9b7f670143efa3
 */
fun transcribeToRna(dna: String): String =
        dna.fold("") { acc, nucleotide ->
            acc + when (nucleotide) {
                'G' -> 'C'
                'C' -> 'G'
                'T' -> 'A'
                'A' -> 'U'
                else -> throw IllegalArgumentException("DNA input string contains characters not in {G, C, T, A}")
            }
        }