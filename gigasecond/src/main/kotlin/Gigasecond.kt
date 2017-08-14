import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Gigasecond.kt
 *
 * Calculate the moment when someone has lived for 10^9 seconds.
 *
 * A gigasecond is 10^9 (1,000,000,000) seconds.
 *
 * http://exercism.io/tracks/kotlin/exercises/gigasecond
 * http://exercism.io/submissions/ae634b241fe4436cb169f7ac6d0450a4
 *
 * @author nrojiani
 * @date 8/14/17
 */
data class Gigasecond(val dobWithTime: LocalDateTime) {
    constructor(dateOfBirth: LocalDate) : this(dateOfBirth.atStartOfDay())

    private val GIGASECOND = Math.pow(10.0, 9.0).toLong()
    val date: LocalDateTime = dobWithTime.plusSeconds(GIGASECOND)
}