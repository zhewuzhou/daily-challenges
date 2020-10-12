package zhewuzhou.me.graph

import zhewuzhou.utils.Graph.Node
import java.util.*

fun cloneGraphBFS(node: Node?): Node? {
    if (node == null) return null
    val copied = mutableMapOf<Node, Node>()
    val queue = LinkedList<Node>()
    val copyOfRoot = Node(node.`val`)
    copied[node] = copyOfRoot
    queue.add(node)
    while (queue.isNotEmpty()) {
        val curNode = queue.pop()
        for (n in curNode.neighbors) {
            if (!copied.containsKey(n) && n != null) {
                copied[n] = Node(n.`val`)
                queue.add(n)
            }
            copied[curNode]!!.neighbors.add(copied[n]!!)
        }
    }
    return copyOfRoot
}

fun cloneGraph(node: Node?): Node? {
    val copied = mutableMapOf<Node, Node>()
    fun dfsVisit(node: Node?): Node? {
        if (node == null) return null
        if (!copied.containsKey(node)) {
            copied[node] = Node(node.`val`)
            for (n in node.neighbors) {
                copied[node]!!.neighbors.add(dfsVisit(n))
            }
        }
        return copied[node]!!
    }
    return dfsVisit(node)
}

