import Relationship.*

enum class Relationship {
    EQUAL,
    SUBLIST,
    SUPERLIST,
    UNEQUAL
}

fun <T> List<T>.relationshipTo(other: List<T>): Relationship =
        when {
            this == other -> EQUAL
            this.size > other.size && this.isSuperlistOf(other) -> SUPERLIST
            this.size < other.size && other.isSuperlistOf(this) -> SUBLIST
            else -> UNEQUAL
        }

private fun <T> List<T>.isSuperlistOf(smaller: List<T>): Boolean {
    val sizeDifference = this.size - smaller.size
    return (0..sizeDifference).any { i ->
        this.drop(i).zip(smaller).all {
            (a, b) -> a == b
        }
    }
}