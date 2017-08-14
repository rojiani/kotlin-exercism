package Hamming

/**
 * Hamming.kt
 *
 * http://exercism.io/tracks/kotlin/exercises/hamming
 * http://exercism.io/submissions/b247c50de8484722b0443f9ba6b504ee
 *
 * @author nrojiani
 * @date 8/11/17
 */
fun compute(leftStrand: String, rightStrand: String): Int {
    require (leftStrand.length == rightStrand.length) {
        "leftStrand and rightStrand must be of equal length."
    }
    return leftStrand.zip(rightStrand)
            .count { (l, r) -> l != r }
}
