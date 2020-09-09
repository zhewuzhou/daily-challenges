package zhewuzhou.me.dp


fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordsWithStatus = mutableMapOf<String, Boolean>()
    var minSteps = Int.MAX_VALUE
    for (w in wordList) {
        wordsWithStatus[w] = false
    }
    fun findLadder(path: MutableList<String>) {
        if (path.size > minSteps) {
            return
        }
        val cur = path.last()
        if (cur == endWord) {
            minSteps = Math.min(minSteps, path.size)
            return
        }
        val steps = nextStep(cur, wordsWithStatus)
        for (s in steps) {
            path.add(s)
            wordsWithStatus[s] = true
            findLadder(path)
            path.removeAt(path.lastIndex)
            wordsWithStatus[s] = false
        }
    }
    if (!wordList.contains(endWord)) return 0
    findLadder(mutableListOf(beginWord))
    return if (minSteps == Int.MAX_VALUE) 0 else minSteps
}

fun ifOneCharDiff(s: String, t: String): Boolean {
    val charsArr = IntArray(26) { 0 }
    for (c in s) {
        charsArr[c - 'a'] += 1
    }
    for (c in t) {
        charsArr[c - 'a'] += 1
    }
    return charsArr.filter { it == 1 }.size == 2
}

fun nextStep(b: String, wordDic: Map<String, Boolean>): Set<String> {
    return wordDic
        .filter { !it.value }
        .filter { ifOneCharDiff(b, it.key) }
        .keys
}


