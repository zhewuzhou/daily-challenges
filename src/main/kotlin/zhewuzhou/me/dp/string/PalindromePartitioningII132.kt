package zhewuzhou.me.leetcode140

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
