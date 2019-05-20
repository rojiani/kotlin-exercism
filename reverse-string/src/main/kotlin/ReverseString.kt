tailrec fun reverse(s: String, reversed: String = ""): String = when {
    s.isEmpty() -> reversed
    else -> reverse(s.dropLast(1), reversed + s.last())
}

// or, just: s.reversed()
