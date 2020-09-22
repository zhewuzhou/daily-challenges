package zhewuzhou.me.slidingwindow

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    return threeSum(nums, 0)
}

fun threeSum(nums: IntArray, target: Int): MutableList<MutableList<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    var ni = 0
    while (ni < nums.size - 2) {
        val remaining = target - nums[ni]
        var left = ni + 1
        var right = nums.size - 1
        while (left < right) {
            when ((nums[left] + nums[right]).compareTo(remaining)) {
                1 -> right -= 1
                -1 -> left += 1
                0 -> {
                    result.add(mutableListOf(nums[ni], nums[left], nums[right]))
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
        while (ni < nums.size - 1 && nums[ni] == nums[ni + 1]) {
            ni += 1
        }
        ni += 1
    }
    return result
}

