/**
 * HandshakeCalculator.kt
 *
 * http://exercism.io/exercises/kotlin/secret-handshake/readme
 * http://exercism.io/tracks/kotlin/exercises/secret-handshake
 *
 * @author nrojiani
 * @date 8/15/17
 */
object HandshakeCalculator {
    private val REVERSE_BIT_FLAG = 0b0001_0000

    fun calculateHandshake(n: Int): List<Signal> {
        val handshakeSignals = (Signal.values()).fold(emptyList<Signal>()) { acc, signal ->
            if (n.hasBitFlagSet(signal.bitFlag))
                acc + signal
            else acc
        }

        return if (n.hasBitFlagSet(REVERSE_BIT_FLAG)) handshakeSignals.reversed() else handshakeSignals
    }
}


fun Int.hasBitFlagSet(bitFlag: Int): Boolean = (this and bitFlag) != 0