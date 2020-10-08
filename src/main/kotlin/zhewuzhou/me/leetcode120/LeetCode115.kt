package zhewuzhou.me.leetcode120

fun numDistinctRecursive(s: String, t: String): Int {
    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun search(si: Int, ti: Int): Int {
        val key = Pair(si, ti)
        if (cache.containsKey(key)) return cache[key]!!
        var res = 0
        when {
            ti == t.length -> res = 1
            (si == s.length && ti != t.length) -> res == 0
            (si in s.indices) && (ti in t.indices) -> {
                res = if (s[si] != t[ti]) {
                    search(si + 1, ti)
                } else {
                    search(si + 1, ti + 1) + search(si + 1, ti)
                }
            }
        }
        cache[key] = res
        return cache[key]!!
    }
    return search(0, 0)
}

fun numDistinct(s: String, t: String): Int {
    if (s.isEmpty() && t.isEmpty()) return 1
    if (t.length > s.length || (s.isEmpty() && t.isNotEmpty())) return 0
    val matrix = Array(t.length + 1) {
        IntArray(s.length + 1)
    }
    for (j in 0..s.length) {
        matrix[0][j] = 1
    }
    for (i in t.indices) {
        for (j in s.indices) {
            if (t[i] == s[j]) {
                matrix[i + 1][j + 1] = matrix[i][j] + matrix[i + 1][j]
            } else {
                matrix[i + 1][j + 1] = matrix[i + 1][j]
            }
        }
    }
    return matrix[t.length][s.length]
}

