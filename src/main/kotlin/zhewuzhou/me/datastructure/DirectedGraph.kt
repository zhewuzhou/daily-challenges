package zhewuzhou.me.datastructure

data class DirectedGraph(val V: Int) {
    private var E = 0
    private var adj = Array(V) { mutableListOf<Int>() }
    private val indegree: IntArray = IntArray(V)

    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        indegree[w]++
        E++
    }

    fun adj(v: Int): Iterable<Int> {
        return adj[v]
    }

    fun outdegree(v: Int): Int {
        return adj[v].size
    }

    fun indegree(v: Int): Int {
        return indegree[v]
    }
}
