package zhewuzhou.me.backtracing

fun combine(n: Int, k: Int): List<List<Int>> {
    val source = (1..n).toList()
    if (n < k || n == 0) return listOf()
    fun backtrace(res: MutableList<List<Int>>, comb: MutableList<Int>, start: Int) {
        when (comb.size == k) {
            true -> res.add(arrayOf(*comb.toTypedArray()).toList())
            false -> {
                for (i in start..source.lastIndex) {
                    comb.add(source[i])
                    backtrace(res, comb, i + 1)
                    comb.removeAt(comb.lastIndex)
                }
            }
        }
    }

    val res = mutableListOf<List<Int>>()
    backtrace(res, mutableListOf(), 0)
    return res
}
