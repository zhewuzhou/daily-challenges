package zhewuzhou.me.datastructure

class NumArraySumQuery(val nums: IntArray) {
    private val sum = IntArray(nums.size) { nums[0] }

    init {
        for (i in 1..nums.lastIndex) {
            sum[i] = sum[i - 1] + nums[i]
        }
    }

    fun update(i: Int, value: Int) {
        val pre = nums[i]
        nums[i] = value
        if (value != pre) {
            for (j in i..sum.lastIndex) {
                sum[j] += value - pre
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (i > 0) sum[j] - sum[i - 1] else sum[j]
    }
}
