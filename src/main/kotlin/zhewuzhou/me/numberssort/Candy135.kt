package zhewuzhou.me.numberssort

/**
 * The algorithm should be works as following:
 * 1.Looking forward 0 -> n if candySeq[i] 1,2,3,4
 * candiSeq[i]  = candiSeq[i-1]+1 when rating[i] > ratting[i-1]
 * 2.Looking Backward n->0
 * candiRev[i] = candiRev[i+1]+1 when rating[i-1]>ratting[i]
 */
fun candyDP(ratings: IntArray): Int {
    val candySeq = IntArray(ratings.size) { 1 }
    val candyRevSeq = IntArray(ratings.size) { 1 }
    var res = 0
    for (i in 1..ratings.lastIndex) {
        if (ratings[i] > ratings[i - 1]) {
            candySeq[i] = candySeq[i - 1] + 1
        }
    }
    for (i in (ratings.lastIndex - 1) downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candyRevSeq[i] = candyRevSeq[i + 1] + 1
        }
    }
    for (i in ratings.indices) {
        res += Math.max(candySeq[i], candyRevSeq[i])
    }
    return res
}

/**
 * Native Solution
 */
fun candy(ratings: IntArray): Int {
    if (ratings.isEmpty()) return 0
    if (ratings.size == 1) return 1
    val res = IntArray(ratings.size) {
        1
    }
    val cuts = cutRatings(ratings)
    for (c in cuts) {
        handleSingular(c, res, ratings)
    }
    return res.sum()
}

fun cutRatings(ratings: IntArray): List<List<Int>> {
    val cuts = mutableListOf<List<Int>>()
    var trend = ratings[1].compareTo(ratings[0])
    var start = 2
    val cut = mutableListOf(0, 1)
    while (start <= ratings.lastIndex) {
        val tail = cut.last()
        val newTrend = ratings[start].compareTo(ratings[tail])
        if (newTrend != trend) {
            cuts.add(listOf(*cut.toTypedArray()))
            cut.clear()
            cut.add(tail)
        }
        cut.add(start)
        trend = newTrend
        start += 1
    }
    cuts.add(listOf(*cut.toTypedArray()))
    return cuts
}

private fun handleSingular(index: List<Int>, res: IntArray, ratings: IntArray) {
    val pre = res[index[0]]
    res[index[0]] = 1
    when (ratings[index[1]].compareTo(ratings[index[0]])) {
        1 -> {
            for (i in index.indices) {
                res[index[i]] += i
            }
        }
        -1 -> {
            for (i in index.lastIndex downTo 0) {
                res[index[i]] += index.lastIndex - i
            }
        }
    }
    res[index[0]] = Math.max(res[index[0]], pre)
}
