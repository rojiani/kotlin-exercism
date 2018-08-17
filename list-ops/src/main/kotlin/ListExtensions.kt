val <T> List<T>.customSize: Int
    get() {
        var count = 0
        forEach { count++ }
        return count
    }

fun <T> List<T>.customReverse(): List<T> {
    val reversed = mutableListOf<T>()
    (lastIndex downTo 0).forEach { i ->
        reversed.add(this[i])
    }
    return reversed
}

fun <T> List<T>.customAppend(elements: List<T>): List<T> = this + elements

fun <T> List<List<T>>.customConcat(): List<T> = this.flatMap { it }

// Without using flatMap (library function)
fun <T> List<List<T>>.customConcat2(): List<T> {
    var result = mutableListOf<T>()
    forEach { sublist ->
        result.addAll(sublist)
    }
    return result
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    forEach { element ->
        if (predicate(element)) {
            result.add(element)
        }
    }
    return result
}

fun <T, R> List<T>.customMap(transform: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    forEach { element ->
        result.add(transform(element))
    }
    return result
}

fun <T, R> List<T>.customFoldLeft(
    initial: R,
    operation: (acc: R, T) -> R
): R {
    var accumulator = initial
    forEach { element ->
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

fun <T, R> List<T>.customFoldRight(
    initial: R,
    operation: (T, acc: R) -> R
): R {
    var accumulator = initial
    (lastIndex downTo 0).forEach { index ->
        accumulator = operation(this[index], accumulator)
    }
    return accumulator
}

