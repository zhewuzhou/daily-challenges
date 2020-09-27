package zhewuzhou.me.backtracing

import zhewuzhou.me.string.allList

fun permuteAllList(nums: IntArray): List<List<Int>> =
    allList(nums.size)
        .map { indexList -> indexList.map { nums[it] } }
        .distinct()

fun permute(nums: IntArray): List<List<Int>> {
    fun backtrace(res: MutableList<List<Int>>, comb: MutableList<Int>) {
        if (comb.size == nums.size) {
            res.add(listOf(*comb.toTypedArray()))
            return
        }
        for (i in nums.indices) {
            if (comb.contains(nums[i])) continue
            comb.add(nums[i])
            backtrace(res, comb)
            comb.removeAt(comb.lastIndex)
        }
    }

    val result = mutableListOf<List<Int>>()
    backtrace(result, mutableListOf())
    return result.toList()
}
