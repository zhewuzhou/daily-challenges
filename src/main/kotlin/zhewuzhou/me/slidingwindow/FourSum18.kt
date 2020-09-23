package zhewuzhou.me.slidingwindow

private fun threeSum(nums: IntArray, pos: Int, reminder: Int): MutableList<MutableList<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    var ni = pos
    while (ni < nums.size - 2) {
        val target = reminder - nums[ni]
        var start = ni + 1
        var end = nums.size - 1
        while (start < end) {
            when ((nums[start] + nums[end]).compareTo(target)) {
                1 -> end -= 1
                -1 -> start += 1
                0 -> {
                    result.add(mutableListOf(nums[ni], nums[start], nums[end]))
                    while (start < end && nums[start] == nums[start + 1]) {
                        start += 1
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end -= 1
                    }
                    start += 1
                    end = nums.size - 1
                }
            }
        }
        while (ni < nums.size - 1 && nums[ni] == nums[ni + 1]) {
            ni += 1
        }
        ni += 1
    }
    return result
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) {
        return listOf()
    }
    val result = mutableListOf<MutableList<Int>>()
    nums.sort()
    var pos = 0
    val ts = nums.size
    val max3Sum = nums[ts - 1] + nums[ts - 2] + nums[ts - 3]
    while (pos < ts - 3) {
        val min3Sum = nums[pos + 1] + nums[pos + 2] + nums[pos + 3]
        val curTarget = target - nums[pos]
        if (curTarget in min3Sum..max3Sum) {
            val possibleThree = threeSum(nums, pos + 1, curTarget)
            if (possibleThree.isNotEmpty()) {
                possibleThree.map { it.add(0, nums[pos]) }
            }
            result.addAll(possibleThree)
        }
        while (pos < nums.size - 3 && nums[pos] == nums[pos + 1]) {
            pos += 1
        }
        pos += 1
    }
    return result
}
