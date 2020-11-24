package zhewuzhou.me.backtracing.bfs

import java.util.*


fun findLaddersConcise(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    val wordSet: MutableSet<String> = HashSet(wordList)
    if (!wordSet.contains(endWord)) return ArrayList()
    var layer = mutableMapOf(
            beginWord to mutableListOf(mutableListOf(beginWord))
    )
    while (layer.isNotEmpty()) {
        val newLayer = mutableMapOf<String, MutableList<MutableList<String>>>()
        for (word in layer.keys) {
            if (word == endWord) {
                return layer[word]!!
            }
            for (i in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0, i) + c + word.substring(i + 1)
                    if (!wordSet.contains(newWord)) continue
                    if (!newLayer.containsKey(newWord)) {
                        newLayer[newWord] = mutableListOf()
                    }
                    for (list in layer[word]!!) {
                        val newList = mutableListOf(*list.toTypedArray())
                        newList.add(newWord)
                        newLayer[newWord]!!.add(newList)
                    }
                }
            }
        }
        layer = newLayer
        for (str in newLayer.keys) {
            wordSet.remove(str)
        }
    }
    return ArrayList()
}

private fun getNeighbors(node: String, dict: Set<String>): List<String> {
    val res = mutableListOf<String>()
    val chs = node.toCharArray()
    var c = 'a'
    while (c <= 'z') {
        for (i in chs.indices) {
            if (chs[i] == c) continue
            val oldC = chs[i]
            chs[i] = c
            if (dict.contains(String(chs))) {
                res.add(String(chs))
            }
            chs[i] = oldC
        }
        c++
    }
    return res
}


fun findLadders(start: String, end: String, wordList: List<String>): List<List<String>> {
    val dict = HashSet(wordList)
    val res = mutableListOf<List<String>>()
    val nbs = mutableMapOf<String, MutableList<String>>()
    val distance = mutableMapOf<String, Int>()
    dict.add(start)
    fun bfs() {
        for (str in dict) nbs[str] = ArrayList()
        val queue: Queue<String> = LinkedList()
        queue.offer(start)
        distance[start] = 0
        while (!queue.isEmpty()) {
            val count: Int = queue.size
            var foundEnd = false
            for (i in 0 until count) {
                val cur = queue.poll()
                val curDistance = distance[cur]!!
                val neighbors: List<String> = getNeighbors(cur, dict)
                for (neighbor in neighbors) {
                    nbs[cur]!!.add(neighbor)
                    if (!distance.containsKey(neighbor)) { // Check if visited
                        distance[neighbor] = curDistance + 1
                        if (end == neighbor) // Found the shortest path
                            foundEnd = true else queue.offer(neighbor)
                    }
                }
            }
            if (foundEnd) break
        }
    }

    fun dfs(cur: String, comb: MutableList<String>, res: MutableList<List<String>>) {
        comb.add(cur)
        if (end == cur) {
            res.add(listOf(*comb.toTypedArray()))
        } else {
            for (next in nbs[cur]!!) {
                if (distance[next] == distance[cur]!! + 1) {
                    dfs(next, comb, res)
                }
            }
        }
        comb.removeAt(comb.size - 1)
    }
    bfs()
    dfs(start, mutableListOf(), res)
    return res
}
