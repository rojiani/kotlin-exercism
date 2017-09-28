/**
 * ETL
 *
 * http://exercism.io/exercises/kotlin/etl/readme
 * http://exercism.io/tracks/kotlin/exercises/etl
 * http://exercism.io/submissions/b5a2285f9fc642b8b5c19463104d60de
 *
 * See also http://exercism.io/submissions/63aed7db0a444c9da24d59588b2b513f
 *
 * @author nrojiani
 * @date 9/7/17
 */
object ETL {

    fun transform(old: Map<Int, List<Char>>): Map<Char, Int> =
                old.flatMap { (score, letters) ->
                    letters.map { it.toLowerCase() to score }
                }.toMap()
}
