import java.util.Random

/**
 * Robot
 *
 * http://exercism.io/exercises/kotlin/robot-name/readme
 * http://exercism.io/tracks/kotlin/exercises/robot-name
 * http://exercism.io/submissions/e2d6d181b73c4aa9b0e45cf28eb5415d
 *
 * @author nrojiani
 * @date 8/24/17
 */
class Robot {
    var name: String = generateRobotName()

    fun reset() {
        name = generateRobotName()
    }

    private fun generateRobotName(): String {
        val random = Random()
        return (1..5).fold("") { acc, i->
            acc + when(i) {
                in 1..2 -> random.nextUppercaseChar()
                else    -> random.nextDigit()
            }
        }
    }
}

/* Inspired by http://exercism.io/submissions/378902efae8d4cff9dbd66f057abd61f */
private fun Random.nextUppercaseChar(): Char = (this.nextInt(('A'..'Z').count()) + 'A'.toInt()).toChar()
private fun Random.nextDigit(): Int = (this.nextInt(10))
