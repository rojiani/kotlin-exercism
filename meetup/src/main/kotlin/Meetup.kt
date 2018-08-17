import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

/**
 *
 * http://exercism.io/exercises/kotlin/meetup/readme
 * https://exercism.io/my/solutions/0da3bda10a2042a88ab48d6d1b88c404
 *
 * @author nrojiani
 * @date 11/22/17
 */
class Meetup(private val month: Int, private val year: Int) {

    /** First day of given month & year. */
    private val baseDate: LocalDate = LocalDate.of(year, month, 1)

    fun day(day: DayOfWeek, schedule: MeetupSchedule): LocalDate =
        when (schedule) {
            MeetupSchedule.TEENTH -> matchTeenthDay(day)
            MeetupSchedule.LAST -> baseDate.with(TemporalAdjusters.lastInMonth(day))
            else -> findOrdinalDayInMonth(day, schedule)
        }

    private fun matchTeenthDay(day: DayOfWeek): LocalDate {
        val date = LocalDate.of(year, month, 13) // "-teenth" days will be between the 13th through 19th

        return if (date.dayOfWeek == day)
            date
        else date.with(TemporalAdjusters.next(day))
    }

    private fun findOrdinalDayInMonth(day: DayOfWeek, scheduleOrdinal: MeetupSchedule): LocalDate {
        val ordinalNameToInt = mapOf(
            MeetupSchedule.FIRST to 1,
            MeetupSchedule.SECOND to 2,
            MeetupSchedule.THIRD to 3,
            MeetupSchedule.FOURTH to 4
        )

        return baseDate.with(TemporalAdjusters.dayOfWeekInMonth(ordinalNameToInt[scheduleOrdinal]!!, day))
    }

}