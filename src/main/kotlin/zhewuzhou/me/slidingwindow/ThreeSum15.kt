package zhewuzhou.me.slidingwindow

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    return threeSum(nums, 0, 0)
}

fun threeSum(nums: IntArray, target: Int, start: Int): MutableList<MutableList<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    var lower = start
    while (lower < nums.size - 2) {
        val t = target - nums[lower]
        var left = lower + 1
        var right = nums.size - 1
        while (left < right) {
            when ((nums[left] + nums[right]).compareTo(t)) {
                1 -> right -= 1
                -1 -> left += 1
                0 -> {
                    result.add(mutableListOf(nums[lower], nums[left], nums[right]))
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1
                    }
                    left += 1
                    right = nums.size - 1
                }
            }
        }
        while (lower < nums.size - 1 && nums[lower] == nums[lower + 1]) {
            lower += 1
        }
        lower += 1
    }
    return result
}

