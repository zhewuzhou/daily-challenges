package zhewuzhou.me.backtracing

import java.util.*


fun getPermutationBackTracing(n: Int, k: Int): String {
    val seq = (1..n).toList()
    fun backtrace(res: MutableList<List<Int>>, comb: MutableList<Int>) {
        if (res.size == k) {
            return
        }
        when (comb.size == seq.size) {
            true -> {
                res.add(listOf(*comb.toTypedArray()))
            }
            false -> {
                for (i in seq.indices) {
                    if (!comb.contains(seq[i])) {
                        comb.add(seq[i])
                        backtrace(res, comb)
                        comb.removeAt(comb.lastIndex)
                    }
                }
            }
        }
    }

    val res = mutableListOf<List<Int>>()
    backtrace(res, mutableListOf())
    return res[res.lastIndex].joinToString("") { it.toString() }
}

/*
1. Should know it's n! even it's familiar backtrace
2. Always looking for the better solution
 */
fun getPermutation(n: Int, k: Int): String {
    var seq = k
    val numbers: MutableList<Int> = ArrayList()
    val factorial = IntArray(n + 1)
    val sb = StringBuilder()

    var sum = 1
    factorial[0] = 1
    for (i in 1..n) {
        sum *= i
        factorial[i] = sum
    }
    for (i in 1..n) {
        numbers.add(i)
    }
    seq -= 1
    for (i in 1..n) {
        val index = seq / factorial[n - i]
        sb.append(numbers[index].toString())
        numbers.removeAt(index)
        seq -= index * factorial[n - i]
    }
    return sb.toString()
}
