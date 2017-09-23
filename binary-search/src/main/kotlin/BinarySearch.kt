package BinarySearch

/**
 * BinarySearch
 *
 * http://exercism.io/exercises/kotlin/binary-search/readme
 * http://exercism.io/tracks/kotlin/exercises/binary-search
 * http://exercism.io/submissions/b2e9fda2bab54901acb398b3c778185e
 *
 * @author nrojiani
 * @date 9/22/17
 */

const val NOT_FOUND: Int = -1

fun <T : Comparable<T>> search(list: List<T>, searchKey: T): Int {
    require(list.isSorted())

    var range = 0..list.lastIndex
    var mid: Int

    while (!range.isEmpty()) {
        mid = (range.start + range.endInclusive) / 2
        when {
            list[mid] == searchKey -> return mid
            searchKey < list[mid] -> { range = 0 until mid }
            searchKey > list[mid] -> { range = mid + 1..list.lastIndex }
        }
    }

    return NOT_FOUND
}

fun <T: Comparable<T>> List<T>.isSorted(): Boolean =
        (0 until lastIndex).all { i -> this[i] <= this[i + 1] }