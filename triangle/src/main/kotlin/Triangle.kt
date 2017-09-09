/**
 * Triangle.kt
 *
 * http://exercism.io/exercises/kotlin/triangle/readme
 * http://exercism.io/tracks/kotlin/exercises/triangle
 * http://exercism.io/submissions/4b8b1bfe56cd41a4b958e07697b8b9f1
 *
 * Other solutions:
 * http://exercism.io/submissions/f37b449eb93f403b848d191ab6595142
 * http://exercism.io/submissions/7443f6fc04d74bfda4b4c1417ae4aab5
 * http://exercism.io/submissions/82810b0ebbb445b8830cfe9f4f73aa59 - interesting use of Sets
 *
 * @author nrojiani
 * @date 8/17/17
 */
data class Triangle(private val a: Double, private val b: Double, private val c: Double) {
    constructor(a: Int, b: Int, c: Int) :
            this(a.toDouble(), b.toDouble(), c.toDouble())

    init {
        val noZeroLengthSides = listOf(a, b, c).all { it > 0.0 }
        val triangleInequality = (a + b > c) && (a + c > b) && (b + c > a)
        require(noZeroLengthSides) { "All side lengths must be > 0"}
        require(triangleInequality) { "Not a triangle -> violates triangle inequality"}
    }

    val isEquilateral = (a == b) && (b == c)
    val isIsosceles = (a == b || a == c || b == c)
    val isScalene = (a != b && a != c && b != c)
}