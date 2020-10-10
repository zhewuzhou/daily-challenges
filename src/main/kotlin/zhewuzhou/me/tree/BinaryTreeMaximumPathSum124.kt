package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

fun maxPathSum(root: TreeNode?): Int {
    var maxValue = Int.MIN_VALUE
    fun maxPathDown(node: TreeNode?): Int {
        if (node == null) return 0
        val left: Int = Math.max(0, maxPathDown(node.left))
        val right: Int = Math.max(0, maxPathDown(node.right))
        maxValue = Math.max(maxValue, left + right + node.`val`)
        return Math.max(left, right) + node.`val`
    }
    maxPathDown(root)
    return maxValue
}
