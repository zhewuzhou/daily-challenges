package zhewuzhou.me.numberssort

//Micro view && Overview
fun grayCode(n: Int): List<Int> {
    val res = mutableListOf(0)
    for (x in 0 until n) {
        val s = res.size - 1
        for (i in s downTo 0) {
            res.add(res[i] or (1 shl x))
        }
    }
    return res
}

/**
 * This is slow backtrace version
 */

fun grayCode(res: MutableList<Int>, source: List<Int>, comb: MutableList<Int>): Boolean {
    when (comb.size == source.size) {
        true -> {
            res.addAll(comb)
            return true
        }
        false -> {
            for (n in source) {
                if (!comb.contains(n) && isDiffInOneBit(comb.last(), n)) {
                    comb.add(n)
                    if (grayCode(res, source, comb)) {
                        return true
                    } else {
                        comb.removeAt(comb.lastIndex)
                    }
                }
            }
            return false
        }
    }
}

fun isDiffInOneBit(a: Int, b: Int): Boolean {
    val diff = a.xor(b)
    return diff != 0 && (diff.and(diff - 1) == 0)
}
