/**
 * Flattener
 *
 * http://exercism.io/exercises/kotlin/flatten-array/readme
 * http://exercism.io/tracks/kotlin/exercises/flatten-array
 *
 * @author nrojiani
 * @date 8/21/17
 */
object Flattener {
    fun flatten(list: List<Any?>): List<Any> =
            list.flatMap {
                when (it) {
                    is List<*> -> flatten(it)
                    else       -> listOf(it).filterNotNull()
                }
            }
}