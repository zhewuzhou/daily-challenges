package zhewuzhou.me.leetcode340

fun wiggleSort(nums: IntArray): Unit {
    makePairsOfSmallLarge(nums)
    var cur = 1
    while (cur < nums.lastIndex) {
        if (nums[cur] < nums[cur + 1]) {
            swap(nums, cur, cur + 1)
        } else if (nums[cur] == nums[cur + 1]) {
            swap(nums, cur - 1, cur + 1)
            swap(nums, cur, cur + 2)
            if (cur >= 3 && nums[cur - 2] < nums[cur - 1]) {
                swap(nums, cur - 3, cur - 1)
                swap(nums, cur - 2, cur)
            }
        }
        cur += 2
    }
}

private fun makePairsOfSmallLarge(nums: IntArray) {
    var cur = 0
    while (cur < nums.lastIndex) {
        if (nums[cur] > nums[cur + 1]) {
            swap(nums, cur, cur + 1)
        } else if (nums[cur] == nums[cur + 1]) {
            var i = cur + 2
            while (i <= nums.lastIndex && nums[i] == nums[cur]) {
                i += 1
            }
            swap(nums, cur + 1, i)
            if (nums[cur] > nums[cur + 1]) {
                swap(nums, cur, cur + 1)
            }
        }
        cur += 2
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}
