package zhewuzhou.me.backtracing

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    fun backtrace(res: MutableSet<List<Int>>, comb: MutableList<Int>, start: Int) {
        res.add(listOf(*comb.toTypedArray().sortedArray()))
        if (comb.size < nums.size - 1) {
            for (i in start until nums.size) {
                comb.add(nums[i])
                backtrace(res, comb, i + 1)
                comb.removeAt(comb.lastIndex)
            }
        }
    }
    if (nums.isEmpty()) return listOf(listOf())
    val res = mutableSetOf(listOf<Int>())
    backtrace(res, mutableListOf(), 0)
    res.add(nums.toList().sorted())
    return res.toList()
}

