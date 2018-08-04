import java.time.DayOfWeek
import java.time.LocalDate

/**
 *
 * http://exercism.io/exercises/kotlin/meetup/readme
 *
 * @author nrojiani
 * @date 11/22/17
 */
class Meetup(day: Int, year: Int) {
    fun day(day: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        TODO()
    }
}
/*
day - "day" -> (monday).drop(3) + "teenth"
endsWith("teenth")
 */


/*
Typically meetups happen on the same day of the week. In this exercise, you will take a description of a meetup date, and return the actual meetup date.

The first Monday of January 2017
The third Tuesday of January 2017
The wednesteenth of January 2017
The last Thursday of January 2017

The descriptors you are expected to parse are:
first,
second,
third,
fourth,
fifth,
last,
monteenth,
tuesteenth,
wednesteenth,
thursteenth,
friteenth,
saturteenth,
sunteenth

there are exactly 7 numbered days in a month that end in '-teenth'
Therefore, one is guaranteed that each day of the week (Monday, Tuesday, ...) will have exactly one date that is named with '-teenth' in every month.

13th - 19th

monteeth = Monday 16th


Given examples of a meetup dates, each containing a month, day, year, and descriptor calculate the date of the actual meetup.
For example, if given "The first Monday of January 2017", the correct meetup date is 2017/1/2.
 */