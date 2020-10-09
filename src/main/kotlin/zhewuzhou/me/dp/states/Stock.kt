package zhewuzhou.me.dp.states

import java.util.*

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
    var oneInHand = -prices[0]
    var nonInHand = 0
    for (i in 1..prices.lastIndex) {
        val preOneInHand = oneInHand
        val preNonInHand = nonInHand
        oneInHand = Math.max(preNonInHand - prices[i], preOneInHand)
        nonInHand = Math.max(preNonInHand, preOneInHand + prices[i])
    }
    return nonInHand
}

fun maxProfit122Stack(prices: IntArray): Int {
    if (prices.size < 2) return 0
    val s = Stack<Int>()
    var maxProfit = 0
    for (p in prices) {
        if (s.isEmpty() || p > s.peek()) {
            s.push(p)
        } else {
            if (s.size >= 2) {
                maxProfit += s.peek() - s[0]
            }
            s.clear()
            s.push(p)
        }
    }
    return if (s.isNotEmpty() && s.size >= 2) (maxProfit + (s.peek() - s[0])) else maxProfit
}
