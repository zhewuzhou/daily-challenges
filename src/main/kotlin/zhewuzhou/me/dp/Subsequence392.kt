package zhewuzhou.me.dp

fun isSubsequenceRecur(s: String, t: String): Boolean {
    fun subsequence(sPos: Int, tPos: Int): Boolean {
        if (sPos == s.length) return true
        var tNext = -1
        for (i in tPos until t.length) {
            if (s[sPos] == t[i]) {
                tNext = i + 1
                break
            }
        }
        return if (tNext == -1) false else subsequence(sPos + 1, tNext)
    }
    return subsequence(0, 0)
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var indexS = 0
    var indexT = 0
    while (indexT < t.length) {
        if (t[indexT] == s[indexS]) {
            indexS++
            if (indexS == s.length) return true
        }
        indexT++
    }
    return false
}
