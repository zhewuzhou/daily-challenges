package zhewuzhou.me.dp.states

/**
 * No. 121, one transaction for max profit
 */

fun maxProfit121(prices: IntArray): Int {
    if (prices.size < 2) return 0
    var maxProfit = 0
    var minPrice = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice)
        } else {
            minPrice = Math.min(minPrice, prices[i])
        }
    }
    return maxProfit
}

/**
 * No. 122
 * For day x, we have 2 states
 * 1. 1 stock in hand, matrix[x][1]
 * 2. 0 stock in hand, matrix[x][0]
 *
 * Thus:
 * 1. matrix[x][1] = Math.max(matrix[x-1][1], matrix[x-1][0] - prices[x])
 * 2. matrix[x][0] = Math.max(matrix[x-1][0], matrix[x-1][1] + prices[x])
 *
 * Init:
 * matrix[0][1] = -prices[0]
 * matrix[0][0] = 0
 */

fun maxProfit122(prices: IntArray): Int {
    val matrix = Array(prices.size) { IntArray(2) }
    matrix[0][1] = -prices[0]
    for (i in 1..prices.lastIndex) {
        matrix[i][0] = Math.max(matrix[i - 1][0], matrix[i - 1][1] + prices[i])
        matrix[i][1] = Math.max(matrix[i - 1][1], matrix[i - 1][0] - prices[i])
    }
    return matrix.last()[0]
}
