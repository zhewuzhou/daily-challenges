package zhewuzhou.me.datastructure

class UF(val n: Int) {
    private val parent: IntArray = IntArray(n)
    private val rank: ByteArray = ByteArray(n)
    private var count: Int = n


    init {
        for (i in 0 until n) {
            parent[i] = i
            rank[i] = 0
        }
    }

    fun count(): Int {
        return count
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP == rootQ) return

        when {
            rank[rootP] < rank[rootQ] -> parent[rootP] = rootQ
            rank[rootP] > rank[rootQ] -> parent[rootQ] = rootP
            else -> {
                parent[rootQ] = rootP
                rank[rootP]++
            }
        }
        count--
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }


    private fun find(num: Int): Int {
        var p = num
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]
            p = parent[p]
        }
        return p
    }
}
