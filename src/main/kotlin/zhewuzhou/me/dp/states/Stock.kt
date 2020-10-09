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

/**
 * No.3 At most 2 transactions
 * For Day x, k in (1..2):
 * 1. T[x][k][0] stands for in x day with k transaction and 0 stack in hand
 * 2. T[x][k][1] stands for in x day with k transaction and 0 stack in hand
 *
 * Thus:
 * T[x][k][0] = max(T[x-1][k-1][1] + prices[x], T[x-1][k-1][0])
 * T[x][k][1] = max(T[x-1][k-1][0] - prices[x], T[x-1][k-1][1])
 *
 * Init:
 * when tx==0 or day==0 the value should be -price[i]*s where s in 0..1
 */

fun maxProfit123Rec(prices: IntArray): Int {
    val cache = mutableMapOf<Triple<Int, Int, Int>, Int>()

    //t stands for transactions
    fun maxProfitInternal(d: Int, k: Int, s: Int): Int {
        val key = Triple(d, k, s)
        if (cache.containsKey(key)) return cache[key]!!
        var res = 0
        if (d == 0 || k == 0) {
            res = -prices[d] * s
        } else {
            res = when (s) {
                0 -> Math.max(maxProfitInternal(d - 1, k, s), maxProfitInternal(d - 1, k, 1) + prices[d])
                else -> Math.max(maxProfitInternal(d - 1, k, s), maxProfitInternal(d - 1, k - 1, 0) - prices[d])
            }
        }
        cache[key] = res
        return cache[key]!!
    }
    return maxProfitInternal(prices.lastIndex, 2, 0)
}

fun maxProfit123(prices: IntArray): Int {
    val t = Array(prices.size) { Array(3) { IntArray(2) } }
    for (day in t.indices) {
        for (tx in 0..2) {
            for (stock in 0..1) {
                if (tx == 0 || day == 0) {
                    t[day][tx][stock] = -prices[day] * stock
                }
            }
        }
    }
    for (day in 1..t.lastIndex) {
        for (tx in 1..2) {
            t[day][tx][0] = Math.max(t[day - 1][tx][0], t[day - 1][tx][1] + prices[day])
            t[day][tx][1] = Math.max(t[day - 1][tx][1], t[day - 1][tx - 1][0] - prices[day])
        }
    }
    return t.last()[2][0]
}
