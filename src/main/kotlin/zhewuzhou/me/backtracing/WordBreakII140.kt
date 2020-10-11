package zhewuzhou.me.leetcode140

import zhewuzhou.me.dp.string.wordBreak

fun wordBreakII(s: String, wordDict: List<String>): List<String> {
    if (wordDict.isEmpty() || wordDict.all { it.isEmpty() }) return listOf()
    if (s.isEmpty() || !wordBreak(s, wordDict)) return listOf()
    val maxSize = wordDict.maxBy { it.length }!!.length
    val minSize = wordDict.minBy { it.length }!!.length

    fun backtrace(res: MutableList<String>,
                  comb: MutableList<String>,
                  start: Int) {
        if (start == s.length) {
            res.add(comb.joinToString(" "))
        } else {
            val nexts = mutableListOf<String>()
            for (i in (start + minSize)..Math.min(s.length, start + maxSize)) {
                val sub = s.substring(start, i)
                if (wordDict.contains(sub)) {
                    nexts.add(sub)
                }
            }
            for (n in nexts) {
                comb.add(n)
                backtrace(res, comb, start + n.length)
                comb.removeAt(comb.lastIndex)
            }
        }
    }

    val res = mutableListOf<String>()
    backtrace(res, mutableListOf(), 0)
    return res
}

