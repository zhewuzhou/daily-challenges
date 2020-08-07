package zhewuzhou.me.leetcode300

fun findDuplicate(nums: IntArray): Int {
    if (nums.size < 2) return -1
    var walker = nums[0]
    var runner = nums[nums[0]]
    var result = 0
    while (walker != runner) {
        walker = nums[walker]
        runner = nums[nums[runner]]
    }
    while (walker != result) {
        walker = nums[walker]
        result = nums[result]
    }
    return result
}
