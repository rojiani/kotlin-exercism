/**
 * School
 *
 * http://exercism.io/exercises/kotlin/grade-school/readme
 * http://exercism.io/tracks/kotlin/exercises/grade-school
 * http://exercism.io/submissions/b40c78257b75489e87c70b695230fe3d
 *
 * @author nrojiani
 * @date 9/14/17
 */
class School {

    private var database: MutableMap<Int, List<String>> = mutableMapOf()

    fun db(): Map<Int, List<String>> = database.toMap()

    fun add(student: String, grade: Int) {
        val oldRoster = database[grade] ?: emptyList()
        database.put(grade, oldRoster + student)
    }

    fun grade(n: Int): List<String> = database[n] ?: emptyList()

    fun sort(): Map<Int, List<String>> = database.toSortedMap()
            .mapValues { (_, v) -> v.sorted() }
}
