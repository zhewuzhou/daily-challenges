package zhewuzhou.me.numberssort.search

/**
 * for example:
 * 12345 -> bucket: 0012340000
 * 54321 -> bucket: 0432100000
 * 55555 -> bucket: 0000040000
 * 2736 ->  bucket: 0002003100
 */
fun maximumSwap(num: Int): Int {
    val digits = num.toString().toCharArray()
    val buckets = IntArray(10)
    for (i in digits.indices) {
        buckets[digits[i] - '0'] = i
    }
    for (i in digits.indices) {
        for (k in 9 downTo digits[i] - '0' + 1) {
            if (buckets[k] > i) {
                val tmp = digits[i]
                digits[i] = digits[buckets[k]]
                digits[buckets[k]] = tmp
                return Integer.valueOf(String(digits))
            }
        }
    }
    return num
}