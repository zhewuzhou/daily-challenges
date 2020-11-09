package zhewuzhou.me.tree

import java.util.*


fun findMinHeightTreesSlow(n: Int, edges: Array<IntArray>): List<Int> {
    if (n < 1) return listOf()
    if (edges.size < n - 1) return listOf()
    fun calculateHeight(root: Int, predecessor: MutableList<Int>): Int {
        val children = edges
            .filter { it.contains(root) }
            .map { if (it[0] == root) it[1] else it[0] }
            .filter { !predecessor.contains(it) }
        if (children.isEmpty()) return 1
        var maxHeight = 0
        predecessor.add(root)
        for (c in children) {
            maxHeight = Math.max(maxHeight, calculateHeight(c, predecessor) + 1)
        }
        return maxHeight
    }

    val result = TreeMap<Int, MutableList<Int>>()
    for (i in 0 until n) {
        val height = calculateHeight(i, mutableListOf())
        if (result.containsKey(height)) {
            result[height]!!.add(i)
        } else {
            result[height] = mutableListOf(i)
        }
    }
    return result[result.keys.first()]!!
}

//Eat all of leaf circle by circle until root remains

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    var total = n
    if (total == 1) return listOf(0)
    val adj: MutableList<MutableSet<Int>> = mutableListOf()
    for (i in 0 until total) adj.add(HashSet())
    for (edge in edges) {
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    }
    var leaves: MutableList<Int> = ArrayList()
    for (i in 0 until total)
        if (adj[i].size == 1) leaves.add(i)
    while (total > 2) {
        total -= leaves.size
        val newLeaves: MutableList<Int> = ArrayList()
        for (i in leaves) {
            val j = adj[i].iterator().next()
            adj[j].remove(i)
            if (adj[j].size == 1) newLeaves.add(j)
        }
        leaves = newLeaves
    }
    return leaves
}
