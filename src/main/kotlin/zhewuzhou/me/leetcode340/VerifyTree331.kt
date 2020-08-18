package zhewuzhou.me.leetcode340

/*
Consider the binary tree if count # node:
1. number of edges = node+1
2. At a given point, edges can not be negative
 */
fun isValidSerialization(preorder: String): Boolean {
    val nodes = preorder.split(',')
    var edges = 1
    for (i in nodes.indices) {
        edges-- // consume one edge
        if (edges < 0) return false
        if (nodes[i] != "#") {
            edges += 2 // generate 2 edges
        }
    }
    return edges == 0
}
