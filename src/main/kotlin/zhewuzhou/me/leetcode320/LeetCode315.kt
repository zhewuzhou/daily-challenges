package zhewuzhou.me.leetcode320


fun countSmaller(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return listOf()
    val length = nums.size
    val arr = Array(length) { IntArray(2) }
    val aux = Array(length) { IntArray(2) }
    for (i in 0 until length) {
        arr[i] = intArrayOf(nums[i], i)
    }
    val count = IntArray(length)
    fun sort(lower: Int, high: Int) {
        if (lower >= high) return
        val mid = lower + (high - lower) / 2
        sort(lower, mid)
        sort(mid + 1, high)
        for (i in lower..high) {
            aux[i] = arr[i]
        }
        var i = lower
        var j = mid + 1
        for (k in lower..high) {
            if (i == mid + 1) {
                arr[k] = aux[j++]
            } else if (j == high + 1 || aux[i][0] <= aux[j][0]) {
                count[aux[i][1]] += j - (mid + 1)
                arr[k] = aux[i++]
            } else {
                arr[k] = aux[j++]
            }
        }
    }
    sort(0, length - 1)
    return count.toList()
}
