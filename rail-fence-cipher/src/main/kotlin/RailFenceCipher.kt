import RailFenceCipher.Direction.DOWN
import RailFenceCipher.Direction.UP

/**
 * Based on [GeeksForGeeks solution](https://www.geeksforgeeks.org/rail-fence-cipher-encryption-decryption/)
 * https://exercism.io/my/solutions/7737e3f5475944eb95b8b4ab6815bdd7
 */
class RailFenceCipher(private val rails: Int) {

    enum class Direction {
        UP, DOWN;

        fun opposite(): Direction = if (this == UP) DOWN else UP
    }

    init {
        require(rails >= 2) { "The number of rails must be >= 2" }
    }

    fun getDecryptedData(encrypted: String): String {
        val m = rails
        val n = encrypted.length

        // Stores the text in rail format
        val railMatrix = Array(m) { CharArray(n) { '.' } }

        var direction = DOWN
        var row = 0
        var col = 0

        // Place '*' where each letter will go
        encrypted.forEach {
            // Change direction if at first or last row
            when (row) {
                0 -> direction = DOWN
                rails - 1 -> direction = UP
            }

            // Place * marker (indicates letter placement)
            railMatrix[row][col] = '*'

            // Find the next position using direction flag
            col++
            when (direction) {
                DOWN -> row++
                UP -> row--
            }
        }

        // Replace * with letters from input
        var encryptedIndex = 0
        for (i in 0 until rails) {
            for (j in encrypted.indices) {
                if (railMatrix[i][j] == '*' && encryptedIndex in encrypted.indices) {
                    railMatrix[i][j] = encrypted[encryptedIndex++]
                }
            }
        }

        // Read the message by moving in zig-zag fashion
        return buildString {
            row = 0
            col = 0

            for (i in encrypted.indices) {
                // Check the direction of flow
                when (row) {
                    0 -> direction = DOWN
                    rails - 1 -> direction = UP
                }

                // place the marker
                if (railMatrix[row][col] != '*') {
                    append(railMatrix[row][col])
                    col++
                }

                // Find the next row using direction flag
                when (direction) {
                    DOWN -> row++
                    UP -> row--
                }
            }
        }
    }

    fun getEncryptedData(text: String): String {
        val m = rails
        val n = text.length

        val railMatrix = Array(m) { CharArray(n) { '.' } }

        var direction: Direction = UP
        var row = 0
        var col = 0

        // Add the letters in the text to the matrix in a zig-zag fashion
        text.forEach { letter ->
            // Check the direction of flow, reversing if necessary
            if (row == 0 || row == rails - 1) {
                direction = direction.opposite()
            }

            railMatrix[row][col++] = letter

            // Find the next row using direction flag
            when (direction) {
                DOWN -> row++
                UP -> row--
            }
        }

        // Return the encrypted version
        return buildString {
            for (i in 0 until rails) {
                for (j in text.indices) {
                    if (railMatrix[i][j] != '.') {
                        append(railMatrix[i][j])
                    }
                }
            }
        }
    }
}