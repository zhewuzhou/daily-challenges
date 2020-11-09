package zhewuzhou.me.dp

import zhewuzhou.utils.TreeNode


fun rob(root: TreeNode?): Int {
    val cache = mutableMapOf<TreeNode, Int>()
    fun robInternal(root: TreeNode?): Int {
        if (cache.containsKey(root)) return cache[root]!!
        if (root == null) return 0
        val robRoot = root.`val` +
            robInternal(root.left?.left) +
            robInternal(root.left?.right) +
            robInternal(root.right?.left) +
            robInternal(root.right?.right)
        val skipRoot = robInternal(root.left) + robInternal(root.right)
        val result = if (robRoot > skipRoot) robRoot else skipRoot
        cache[root] = result
        return result
    }
    return robInternal(root)
}
