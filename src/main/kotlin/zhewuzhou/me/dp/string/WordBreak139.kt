package zhewuzhou.me.dp.string

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return s.isEmpty()
    if (s.isEmpty()) return false
    val maxSize = wordDict.maxBy { it.length }!!.length
    val minSize = wordDict.minBy { it.length }!!.length
    val res = BooleanArray(s.length) {
        false
    }
    for (i in (minSize - 1)..s.lastIndex) {
        var j = Math.max(0, i - maxSize + 1)
        while (!res[i] && j <= (i + 1 - minSize)) {
            val sub = s.substring(j, i + 1)
            if (wordDict.contains(sub)) {
                res[i] = if (j - 1 >= 0) res[j - 1] else true
            }
            j += 1
        }
    }
    return res.last()
}
