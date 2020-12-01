package zhewuzhou.me.dp.string

/*
1. cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
2. If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
 */
fun minCut(s: String): Int {
    val l = s.length
    val cut = IntArray(l)
    val pal = Array(l) { BooleanArray(l) }

    //init all [i,i] are true
    for (i in 0 until l) {
        pal[i][i] = true
    }

    for (i in 0 until l) {
        cut[i] = if (i > 0) cut[i - 1] + 1 else 0
        for (j in 0 until i) {
            val contiguous = j == i - 1
            if (s[j] == s[i] && (contiguous || pal[j + 1][i - 1])) {
                pal[j][i] = true
                cut[i] = if (j == 0) 0 else Math.min(cut[i], cut[j - 1] + 1)
            }
        }
    }
    return cut[l - 1]
}
