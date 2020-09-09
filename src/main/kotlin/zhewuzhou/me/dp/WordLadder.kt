package zhewuzhou.me.dp

/*
1. One word should only be consumed once, otherwise it's not the shortest
2. Backing tracking is really the king to discover all possible combinations
3. When path is larger than minSteps there is no need to go further
4. The really fast way to tell if strings have one char diff is to use IntArray(26) and see if there is two 1s
 */
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
    var diff = 0
    for (i in s.indices) {
        if (s[i] != t[i]) diff += 1
    }
    return diff == 1
}

fun nextStep(b: String, wordDic: Map<String, Boolean>): Set<String> {
    return wordDic
        .filter { !it.value }
        .filter { ifOneCharDiff(b, it.key) }
        .keys
}


