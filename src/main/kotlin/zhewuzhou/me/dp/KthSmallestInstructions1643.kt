package zhewuzhou.me.dp

import java.lang.StringBuilder

/**
 * destination.length == 2
 * 1 <= row, column <= 15
 * 1 <= k <= nCr(row + column, row), where nCr(a, b) denotes a choose b
 */

/**
 * 1. Combination/Permutation
 * 2. Sub Problem
 * 3. Order: fix H then 24/2*2 = 6
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
    var numH = destination[1]
    var numV = destination[0]
    var rem = k
    val comb = calcComb(numH + numV)
    val sb = StringBuilder()
    while (numH != 0 || numV != 0) {
        val maxIndexOfH = if (numH == 0) -1 else comb[numH - 1 + numV][numV]
        if (rem <= maxIndexOfH) {
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