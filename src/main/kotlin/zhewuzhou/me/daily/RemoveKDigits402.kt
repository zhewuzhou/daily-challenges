package zhewuzhou.me.daily

/**
 * 1432219, 1 => 132219
 * 1432219, 2 => 12219
 * 1432219, 3 => 1219
 * Can be reduced to remove 1 digit make it smallest
 */

fun removeLeadingZeros(num: String): String {
    if (num.isEmpty() || num == "0") return num
    var start = 0
    while (start < num.length && num[start] == '0') {
        start += 1
    }
    return when (start) {
        0 -> num
        num.length -> "0"
        else -> num.substring(start)
    }
}

fun removeKdigits(num: String, k: Int): String {
    if (num.isEmpty() || num == "0" || k >= num.length) return "0"
    fun removeDigit(num: String): String {
        if (num.isEmpty() || num == "0") return "0"
        for (i in 0 until num.lastIndex) {
            if (num[i] > num[i + 1]) {
                return num.substring(0, i) + num.substring(i + 1)
            }
        }
        return num.substring(0, num.lastIndex)
    }

    var result = removeLeadingZeros(num)
    for (t in 1..k) {
        result = removeDigit(result)
        result = removeLeadingZeros(result)
    }
    return result
}