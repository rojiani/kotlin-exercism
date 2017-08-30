/**
 * BracketPush
 *
 * http://exercism.io/exercises/kotlin/bracket-push/readme
 * http://exercism.io/tracks/kotlin/exercises/bracket-push
 *
 * @author nrojiani
 * @date 8/29/17
 */
object BracketPush {

    /*
     The accumulator acts like a stack. If there's an opening brace, it adds it.
     If there's a closing brace, it checks whether there is a mismatch, and if not,
     removes it. The stack should be empty at the end.
     */
    fun isValid(input: String): Boolean =
        input.fold(emptyList<Bracket?>()) { stack, c ->
            when {
                c.isOpeningBracket() -> stack + Bracket.fromChar(c)
                c.isClosingBracket() -> {
                    if (stack.isEmpty() || stack.last() != Bracket.fromChar(c))
                        return false

                    stack.dropLast(1)
                }
                else -> stack
            }
        }.isEmpty()
}

enum class Bracket(val braces: Pair<Char, Char>) {
    SQUARE('[' to ']'),
    CURLY('{' to '}'),
    PARENTHESES('(' to ')');

    companion object {
        fun fromChar(c: Char): Bracket? {
            val matches = fun Char.(bracket: Bracket): Boolean = this in bracket.braces.toList()
            return when {
                c.matches(SQUARE) -> SQUARE
                c.matches(CURLY) -> CURLY
                c.matches(PARENTHESES) -> PARENTHESES
                else -> null
            }
        }
    }
}

fun Char.isOpeningBracket(): Boolean = Bracket.values().any { it.braces.first == this }
fun Char.isClosingBracket(): Boolean = Bracket.values().any { it.braces.second == this }
