package zhewuzhou.me.dp.states

/**
 * Consider for negative*negative | positive * positive
 */

fun maxProduct(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var maxherepre = nums[0]
    var minherepre = nums[0]
    var maxsofar = nums[0]
    var maxhere: Int
    var minhere: Int
    for (i in 1 until nums.size) {
        maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i])
        minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i])
        maxsofar = Math.max(maxhere, maxsofar)
        maxherepre = maxhere
        minherepre = minhere
    }
    return maxsofar
}
