import Planet.*
import java.math.BigDecimal

/**
 * SpaceAge.kt
 *
 * http://exercism.io/exercises/kotlin/space-age/readme
 * http://exercism.io/tracks/kotlin/exercises/space-age
 * http://exercism.io/submissions/54e1307d09f04c40843c616ab0890528
 *
 * @author nrojiani
 * @date 8/14/17
 */
data class SpaceAge(val ageInSeconds: Long) {
    val seconds = ageInSeconds

    fun spaceAgeOn(planet: Planet): Double =
            secondsToYears(ageInSeconds / planet.orbitalPeriod)
                    .roundedTo(2)

    fun onEarth()   = spaceAgeOn(EARTH)
    fun onMercury() = spaceAgeOn(MERCURY)
    fun onVenus()   = spaceAgeOn(VENUS)
    fun onMars()    = spaceAgeOn(MARS)
    fun onJupiter() = spaceAgeOn(JUPITER)
    fun onSaturn()  = spaceAgeOn(SATURN)
    fun onUranus()  = spaceAgeOn(URANUS)
    fun onNeptune() = spaceAgeOn(NEPTUNE)

    /**
     * Time conversion & rounding
     */
    companion object TimeUtils {
        private fun toMin(s: Double)      = s / 60.0
        private fun toHours(min: Double)  = min / 60.0
        private fun toDays(hours: Double) = hours / 24.0
        private fun toYears(days: Double) = days / 365.25

        fun secondsToYears(s: Double) = toYears(toDays(toHours(toMin(s))))

        fun Double.roundedTo(decimalPlaces: Int): Double =
                BigDecimal(this).setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP).toDouble()

    }
}
