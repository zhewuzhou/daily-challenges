package zhewuzhou.me.leetcode140

fun minCutCur(s: String): Int {
    val minCutCaches = mutableMapOf<String, Int>()
    val palindromeCaches = mutableMapOf<String, Boolean>()
    fun isPalindrome(src: String): Boolean {
        if (palindromeCaches.containsKey(src)) return palindromeCaches[src]!!
        val result = (0 until (src.length / 2)).all { src[it] == src[src.length - it - 1] }
        palindromeCaches[src] = result
        return result
    }

    fun minCutDP(src: String): Int {
        if (minCutCaches.containsKey(src)) return minCutCaches[src]!!
        if (src.length == 1 || isPalindrome(src)) return 0
        var min = src.lastIndex
        for (i in 1..src.lastIndex) {
            if (isPalindrome(src.substring(0, i))) {
                val remaining = minCutDP(src.substring(i))
                if (min > remaining + 1) {
                    min = remaining + 1
                }
            }
        }
        minCutCaches[src] = min
        return min
    }
    return when (s.length) {
        0 -> 0
        1 -> 0
        else -> {
            if (isPalindrome(s)) 0 else minCutDP(s)
        }
    }
}

/*
1. cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
2. If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
 */
fun minCut(s: String): Int {
    val l = s.length
    val cut = IntArray(l)
    val pal = Array(l) { BooleanArray(l) }
    for (i in 0 until l) {
        var min = i
        for (j in 0..i) {
            if (s[j] == s[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true
                min = if (j == 0) 0 else Math.min(min, cut[j - 1] + 1)
            }
        }
        cut[i] = min
    }
    return cut[l - 1]
}
