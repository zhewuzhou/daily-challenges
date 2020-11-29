package zhewuzhou.me.dp.typical

fun coinChange(coins: IntArray, amount: Int): Int {
    val matrix = IntArray(amount + 1) {
        Int.MAX_VALUE
    }
    matrix[0] = 0
    for (a in 1..amount) {
        for (c in coins) {
            if (a - c >= 0 && matrix[a - c] != Int.MAX_VALUE) {
                matrix[a] = Math.min(matrix[a - c] + 1, matrix[a])
            }
        }
    }
    return if (matrix[amount] == Int.MAX_VALUE) -1 else matrix[amount]
}

fun coinChangeRecur(coins: IntArray, amount: Int): Int {
    val cache = mutableMapOf(0 to 0)
    fun doCoinChange(total: Int): Int {
        if (cache.containsKey(total)) {
            return cache[total]!!
        }
        var result = Int.MAX_VALUE
        for (c in coins) {
            if (total - c >= 0) {
                val sub = doCoinChange(total - c)
                if (sub != -1 && sub < result) {
                    result = Math.min(result, sub + 1)
                }
            }
        }
        cache[total] = if (result == Int.MAX_VALUE) -1 else result
        return cache[total]!!
    }
    return doCoinChange(amount)
}
