package zhewuzhou.me.numberssort.search

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var major = nums[0]
    for (n in nums) {
        if (count == 0) {
            major = n
        }
        count += if (major == n) 1 else -1
    }
    return major
}
