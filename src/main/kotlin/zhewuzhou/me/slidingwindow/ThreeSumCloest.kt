package zhewuzhou.me.slidingwindow

fun threeSumClosest(nums: IntArray, target: Int): Int {
    check(nums.size >= 3)
    nums.sort()
    var ni = 0
    var curCloest: Int? = null
    while (ni < nums.size - 2) {
        val twoMin = nums[ni + 1] + nums[ni + 2]
        var left = ni + 1
        var right = nums.size - 1
        if (curCloest != null && curCloest > target && nums[ni] + twoMin >= curCloest) {
            return curCloest
        }
        while (left < right) {
            val cur = nums[left] + nums[right] + nums[ni]
            if (curCloest == null) {
                curCloest = cur
            }
            when (cur.compareTo(target)) {
                0 -> return target
                1 -> right -= 1
                -1 -> left += 1
            }
            if (Math.abs(cur - target) < Math.abs(curCloest - target)) curCloest = cur
        }
        while (ni < nums.size - 1 && nums[ni] == nums[ni + 1]) {
            ni += 1
        }
        ni += 1
    }
    return curCloest ?: 0
}
