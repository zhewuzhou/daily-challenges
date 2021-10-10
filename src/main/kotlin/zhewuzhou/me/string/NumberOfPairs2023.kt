package zhewuzhou.me.string

import java.util.*

fun numOfPairs(nums: Array<String>, target: String): Int {
    if (nums.isEmpty() || nums.size <= 1 || target.isEmpty()) {
        return 0
    }
    val mapping = TreeMap<String, Int>()
    var total = 0
    for (n in nums) {
        if (mapping.containsKey(n)) {
            mapping[n] = mapping[n]!! + 1
        } else {
            mapping[n] = 1
        }
    }
    for (i in 1 until target.length) {
        val prefix = target.substring(0, i)
        val suffix = target.substring(i)
        if (mapping.containsKey(prefix) && mapping.containsKey(suffix)) {
            if (prefix == suffix) {
                if (mapping[prefix]!! > 1) {
                    total += mapping[prefix]!! * (mapping[prefix]!! - 1)
                }
            } else {
                total += mapping[prefix]!! * mapping[suffix]!!
            }
        }
    }
    return total
}