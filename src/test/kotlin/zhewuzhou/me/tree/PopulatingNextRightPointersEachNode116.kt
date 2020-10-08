package zhewuzhou.me.tree

import zhewuzhou.utils.Node

fun connect(root: Node?): Node? {
    fun connectNeighbors(lhs: Node?, rhs: Node?) {
        if (lhs == null || rhs == null) return
        lhs.next = rhs
        connectNeighbors(lhs.left, lhs.right)
        connectNeighbors(rhs.left, rhs.right)
        connectNeighbors(lhs.right, rhs.left)
    }
    if (root != null) {
        connectNeighbors(root.left, root.right)
    }
    return root
}

