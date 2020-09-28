package zhewuzhou.me.backtracing

fun permuteUnique(nums: IntArray): List<List<Int>> {
    fun backtrace(result: MutableList<MutableList<Int>>, comb: MutableList<Int>, used: BooleanArray) {
        if (comb.size < nums.size) {
            for (i in nums.indices) {
                val preUsed = when (i) {
                    0 -> true
                    else -> {
                        if (nums[i] != nums[i - 1]) {
                            true
                        } else {
                            used[i - 1]
                        }
                    }
                }
                val curUnused = !used[i]
                if (curUnused && preUsed) {
                    used[i] = true
                    comb.add(nums[i])
                    backtrace(result, comb, used)
                    used[i] = false
                    comb.removeAt(comb.lastIndex)
                }
            }
        } else {
            result.add(mutableListOf(*comb.toTypedArray()))
        }
    }

    val result = mutableListOf<MutableList<Int>>()
    backtrace(result, mutableListOf(), BooleanArray(nums.size))
    return result
}
