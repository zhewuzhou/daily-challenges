package zhewuzhou.me.numberssort.sort

fun maximumGap(num: IntArray): Int {
    if (num.size < 2) return 0
    // get the max and min value of the array
    var min = num[0]
    var max = num[0]
    for (i in num) {
        min = Math.min(min, i)
        max = Math.max(max, i)
    }
    // the minimum possibale gap, ceiling of the integer division
    val gap = Math.ceil((max - min).toDouble() / (num.size - 1)).toInt()
    val minBucket = IntArray(num.size - 1) { Int.MAX_VALUE }
    val maxBucket = IntArray(num.size - 1) { Int.MIN_VALUE }
    for (i in num) {
        if (i == min || i == max) continue
        val idx = (i - min) / gap // index of the right position in the buckets
        minBucket[idx] = Math.min(i, minBucket[idx])
        maxBucket[idx] = Math.max(i, maxBucket[idx])
    }
    // scan the buckets for the max gap
    var maxGap = Int.MIN_VALUE
    var previous = min
    for (i in 0 until num.size - 1) {
        if (minBucket[i] == Int.MAX_VALUE && maxBucket[i] == Int.MIN_VALUE) // empty bucket
            continue
        // min value minus the previous value is the current gap
        maxGap = Math.max(maxGap, minBucket[i] - previous)
        // update previous bucket value
        previous = maxBucket[i]
    }
    maxGap = Math.max(maxGap, max - previous) // updata the final max value gap
    return maxGap
}

