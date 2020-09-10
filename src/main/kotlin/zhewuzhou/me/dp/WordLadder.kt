package zhewuzhou.me.dp

/*
1. One word should only be consumed once, otherwise it's not the shortest
2. Backing tracking is really the king to discover all possible combinations
3. When path is larger than minSteps there is no need to go further
4. The really fast way to tell if strings have one char diff is to use IntArray(26) and see if there is two 1s
 */
fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordUsed = mutableMapOf<String, Boolean>()
    var minSteps = wordList.size + 1
    for (w in wordList) {
        wordUsed[w] = false
    }

    fun nextStep(s: String): List<String> {
        val res = mutableListOf<String>()
        val source = s.toCharArray()
        for (i in source.indices) {
            val origin = source[i]
            for (c in 'a'..'z') {
                if (c != origin) {
                    source[i] = c
                    val generated = source.joinToString("")
                    if (wordUsed.containsKey(generated) && !wordUsed[generated]!!) {
                        res.add(generated)
                    }
                }
            }
            source[i] = origin
        }
        return res
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
        val steps = nextStep(cur)
        for (s in steps) {
            if (wordUsed.containsKey(s) && !wordUsed[s]!!) {
                path.add(s)
                wordUsed[s] = true
                findLadder(path)
                path.removeAt(path.lastIndex)
                wordUsed[s] = false
            }
        }
    }
    if (!wordList.contains(endWord)) return 0
    findLadder(mutableListOf(beginWord))
    return if (minSteps == Int.MAX_VALUE) 0 else minSteps
}




