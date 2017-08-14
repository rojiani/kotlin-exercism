/**
 * Planet.kt
 *
 * Solar system planet and the length of its orbital period.
 * @param orbitalPeriod The orbital period of the [Planet] in [EARTH] years.
 *
 * @author nrojiani
 * @date 8/14/17
 */
enum class Planet(val orbitalPeriod: Double) {
    EARTH(1.0),
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132)
}