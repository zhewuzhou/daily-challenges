package zhewuzhou.me.slidingwindow

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) {
        return listOf()
    }
    val result = mutableListOf<MutableList<Int>>()
    nums.sort()
    var pos = 0
    val size = nums.size
    val max3Sum = nums[size - 1] + nums[size - 2] + nums[size - 3]
    while (pos < size - 3) {
        val min3Sum = nums[pos + 1] + nums[pos + 2] + nums[pos + 3]
        val subTarget = target - nums[pos]
        if (subTarget in min3Sum..max3Sum) {
            val threeComb = threeSum(nums, subTarget, pos + 1)
            if (threeComb.isNotEmpty()) {
                threeComb.forEach { it.add(0, nums[pos]) }
            }
            result.addAll(threeComb)
        }
        while (pos < nums.size - 3 && nums[pos] == nums[pos + 1]) {
            pos += 1
        }
        pos += 1
    }
    return result
}
