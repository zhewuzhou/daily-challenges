package zhewuzhou.me.dp

import java.lang.StringBuilder

/**
 * destination.length == 2
 * 1 <= row, column <= 15
 * 1 <= k <= nCr(row + column, row), where nCr(a, b) denotes a choose b
 */

fun calcComb(n: Int): Array<IntArray> {
    val metrics = Array(n + 1) {
        IntArray(n + 1) { 1 }
    }
    for (r in 2..n) {
        for (c in 1 until r) {
            metrics[r][c] = metrics[r - 1][c - 1] + metrics[r - 1][c]
        }
    }
    return metrics
}

fun kthSmallestPath(destination: IntArray, k: Int): String {
    val comb = calcComb(destination[0] + destination[1])
    val sb = StringBuilder()
    var rem = k
    var numH = destination[1]
    var numV = destination[0]
    while (k > 0) {
        val maxIndexOfH = comb[numH - 1 + numV][numV]
        if (k <= maxIndexOfH) {
            sb.append('H')
            numH -= 1
        } else {
            sb.append('V')
            numV -= 1
            rem -= maxIndexOfH
        }
    }
    return sb.toString()
}