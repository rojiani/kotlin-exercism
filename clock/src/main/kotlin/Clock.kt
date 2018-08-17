const val MINS_PER_HOUR = 60
const val HOURS_PER_DAY = 24

class Clock(private var hours: Int, private var minutes: Int) {

    init {
        normalize()
    }

    private val totalMins: Int = (hours * MINS_PER_HOUR) + minutes

    fun add(minsToAdd: Int) {
        val minsSum = totalMins + minsToAdd

        hours = (minsSum / MINS_PER_HOUR) % HOURS_PER_DAY
        minutes = minsSum % MINS_PER_HOUR

        normalize()
    }

    private fun normalize() {
        handleUnderflow()
        handleOverflow()
    }

    private fun handleUnderflow() {
        while (minutes < 0) {
            minutes += MINS_PER_HOUR
            hours -= 1
        }

        while (hours < 0)
            hours += HOURS_PER_DAY
    }

    private fun handleOverflow() {
        if (hours >= HOURS_PER_DAY)
            hours %= HOURS_PER_DAY

        if (minutes >= MINS_PER_HOUR) {
            val additionalHours = minutes / MINS_PER_HOUR
            hours += additionalHours
            minutes %= MINS_PER_HOUR
        }
    }

    override fun toString(): String {
        normalize()

        val to2Digits: (Int) -> String = { String.format("%02d", it) }  // Add leading zeroes where necessary
        return "${to2Digits(hours)}:${to2Digits(minutes)}"
    }

    override fun equals(other: Any?): Boolean {
        other as Clock
        return this.toString() == other.toString()
    }

}