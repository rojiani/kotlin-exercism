/**
 * Allergies
 *
 * http://exercism.io/exercises/kotlin/allergies/readme
 * http://exercism.io/tracks/kotlin/exercises/allergies
 *
 * @author nrojiani
 * @date 8/25/17
 */
data class Allergies(private val allergyScore: Int) {

    fun isAllergicTo(allergen: Allergen): Boolean =
        (allergyScore and allergen.score) == allergen.score

    fun getList(): List<Allergen> = Allergen.values().filter { isAllergicTo(it) }

}