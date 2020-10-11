package zhewuzhou.me.leetcode140

import zhewuzhou.me.dp.string.wordBreak

fun wordBreakII(s: String, wordDict: List<String>): List<String> {
    fun backtrace(res: MutableList<String>,
                  comb: MutableList<String>,
                  src: String,
                  start: Int,
                  wordDict: List<String>,
                  range: Pair<Int, Int>) {
        if (start == src.length) {
            res.add(comb.joinToString(" "))
        } else {
            for (s in getNext(start, src, wordDict, range)) {
                comb.add(s)
                backtrace(res, comb, src, start + s.length, wordDict, range)
                comb.removeAt(comb.lastIndex)
            }
        }
    }
    if (wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return listOf()
    if (s.isEmpty() || !wordBreak(s, wordDict)) return listOf()
    val maxSize = wordDict.maxBy { it.length }!!.length
    val minSize = wordDict.minBy { it.length }!!.length
    val res = mutableListOf<String>()
    backtrace(res, mutableListOf(), s, 0, wordDict, Pair(maxSize, minSize))
    return res
}

private fun getNext(start: Int, s: String, wordDict: List<String>, range: Pair<Int, Int>): List<String> {
    val res = mutableListOf<String>()
    for (i in (start + range.second)..Math.min(s.length, start + range.first)) {
        val sub = s.substring(start, i)
        if (wordDict.contains(sub)) {
            res.add(sub)
        }
    }
    return res
}
