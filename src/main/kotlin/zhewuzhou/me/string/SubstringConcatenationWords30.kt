package zhewuzhou.me.string

fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (s.isEmpty() || words.isEmpty()) {
        return listOf()
    }
    val wordsCount = words.groupBy { it }.mapValues { it.value.size }
    val result = mutableListOf<Int>()
    val sLen = s.length
    val wordNum = words.size
    val wordLen = words[0].length
    for (i in 0 until sLen - wordNum * wordLen + 1) {
        val sub = s.substring(i, i + wordNum * wordLen)
        if (isConcat(sub, wordsCount, wordLen)) {
            result.add(i)
        }
    }
    return result
}

fun isConcat(sub: String, count: Map<String, Int>, wordLen: Int): Boolean {
    val subCount = mutableMapOf<String, Int>()
    for (i in sub.indices step wordLen) {
        val subWord = sub.substring(i, i + wordLen)
        subCount[subWord] = (subCount[subWord] ?: 0) + 1
    }
    return subCount == count
}

fun allList(n: Int): List<List<Int>> {
    return when (n) {
        0 -> listOf()
        1 -> listOf(listOf(0))
        2 -> listOf(listOf(0, 1), listOf(1, 0))
        else -> {
            allList(n - 1).flatMap { allPosition(it, n - 1) }
        }
    }
}

fun allPosition(l: List<Int>, num: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    (0..l.size).forEach {
        val nl = l.toMutableList()
        nl.add(it, num)
        result.add(nl)
    }
    return result
}
