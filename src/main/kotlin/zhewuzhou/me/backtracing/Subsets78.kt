package zhewuzhou.me.backtracing

fun subsets(nums: IntArray): List<List<Int>> {
    val source = nums.toList()
    fun backtrace(res: MutableList<List<Int>>, comb: MutableList<Int>, start: Int) {
        when (comb.size == source.size) {
            true -> return
            false -> {
                res.add(arrayOf(*comb.toTypedArray()).toList())
                for (i in start..source.lastIndex) {
                    comb.add(source[i])
                    backtrace(res, comb, i + 1)
                    comb.removeAt(comb.lastIndex)
                }
            }
        }
    }
    if (nums.isEmpty()) return listOf()
    val res = mutableListOf(nums.toList())
    backtrace(res, mutableListOf(), 0)
    return res
}
