package zhewuzhou.me.devideconquer


fun countSmaller(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return listOf()
    val length = nums.size
    val sortedArr = Array(length) { IntArray(2) }
    val mergeSpace = Array(length) { IntArray(2) }
    for (i in 0 until length) {
        sortedArr[i] = intArrayOf(nums[i], i)
    }
    val count = IntArray(length)
    fun sort(lower: Int, high: Int) {
        if (lower >= high) return
        val mid = lower + (high - lower) / 2
        sort(lower, mid)
        sort(mid + 1, high)
        for (i in lower..high) {
            mergeSpace[i] = sortedArr[i]
        }
        var left = lower
        var right = mid + 1
        for (k in lower..high) {
            if (left == mid + 1) {//the left part is finished
                sortedArr[k] = mergeSpace[right++]
            } else if (right == high + 1 || mergeSpace[left][0] <= mergeSpace[right][0]) {
                //1. current left is large than all right part, pretty hard to understand
                //2. left is smaller, that also mean current left is larger than all pre right
                //5,6,7,8  || 4,6,8,10
                /*
                4,                 r=5, l=0
                4, 6               r=5, l=1 and count[0] = 5-4 = 1
                4, 6, 6            r=6, l=1
                4, 6, 6, 7         r=6, l=2 and count[7] = 6-4 = 2
                 */
                count[mergeSpace[left][1]] += right - (mid + 1)
                sortedArr[k] = mergeSpace[left++]
            } else {
                //Jump from right to left
                sortedArr[k] = mergeSpace[right++]
            }
        }
    }
    sort(0, length - 1)
    return count.toList()
}
