package zhewuzhou.me.dp.typical

/*
    TODO: 1. Stack spam
    TODO: 2. Dynamic programmings comes from the examples
    TODO: 3. Play with more examples
    TODO: 4. Summary of how to write better program
    TODO: 5. Stop when feel not right

    (()) -> when i==2 it should be 2
         -> when i==3
 */
fun longestValidParentheses(s: String): Int {
    if (s.length <= 1) return 0
    var curMax = 0
    val metrics = IntArray(s.length)
    for (i in 1 until s.length) {
        if (s[i] == ')' &&
                i - metrics[i - 1] - 1 >= 0 &&
                s[i - metrics[i - 1] - 1] == '(') {
            metrics[i] = metrics[i - 1] + 2
            metrics[i] += if (i - metrics[i - 1] - 2 >= 0) metrics[i - metrics[i - 1] - 2] else 0
            curMax = Math.max(metrics[i], curMax)
        }
    }
    return curMax
}

fun longestValidParenthesesRecur(s: String): Int {
    val caches = mutableMapOf(0 to 0)
    for (i in s.indices) {
        if (s[i] == '(') {
            caches[i] = 0
        }
    }
    fun doCalcLVP(i: Int): Int {
        if (caches.containsKey(i)) {
            return caches[i]!!
        }
        val preLVP = doCalcLVP(i - 1)
        var result = 0
        val prePosition = i - preLVP - 1
        if (prePosition >= 0 && s[prePosition] == '(') {
            result += preLVP + 2
            if (i - preLVP - 2 >= 0) {
                result += doCalcLVP(i - preLVP - 2)
            }
        }
        caches[i] = result
        return caches[i]!!
    }
    doCalcLVP(s.lastIndex)
    return caches.values.max()!!
}
