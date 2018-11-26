/**
 * Submission: https://exercism.io/my/solutions/c6a3e880894241edabf33faece3ea9c7
 */
data class ChangeCalculator(val denominations: List<Int>) {

    fun computeMostEfficientChange(amount: Int): List<Int> {
        if (amount == 0) return emptyList()

        require(amount >= 0) { "Negative totals are not allowed." }
        require(amount > denominations.first()) { "The total $amount cannot be represented in the given currency." }

        val dp: Array<List<Int>?> = Array(amount + 1) { null }
        dp[0] = emptyList()

        // Bottom-up approach
        for (i in 1..amount) {
            for (coin in denominations) {
                if (coin <= i) {
                    val newSolution = dp[i - coin]?.let { it + coin }
                    if (newSolution != null) {
                        if (dp[i] == null || newSolution.size < dp[i]!!.size) {
                            dp[i] = newSolution
                        }
                    }
                }
            }
        }

        if (dp[amount]?.isEmpty() != false) {
            throw IllegalArgumentException("The total $amount cannot be represented in the given currency.")
        } else {
            return dp[amount]!!.sorted()
        }
    }
}

