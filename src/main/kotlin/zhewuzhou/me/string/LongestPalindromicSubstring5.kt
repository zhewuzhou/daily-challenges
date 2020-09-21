package zhewuzhou.me.string

/*
DP Solution
 */

fun longestPalindrome(s: String): String {
    var res = ""
    val metrics = Array(s.length) {
        BooleanArray(s.length) {
            false
        }
    }
    /*
     * The key is search a small part first
     * Incremental the search space smoothly
     */
    for (i in s.lastIndex downTo 0) {
        for (j in (i + 1)..s.lastIndex) {
            metrics[i][j] = (s[i] == s[j]) && (j - i < 3 || metrics[i + 1][j - 1])
            if (metrics[i][j]) {
                if (j - i + 1 > res.length) {
                    res = s.substring(i, j + 1)
                }
            }
        }
    }
    return res
}
