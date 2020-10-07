package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

/**
 * 1. The 1st element should be root from pre-order
 * 2. Then we should know the left/right according to in-order
 * 3. No duplication in nodes
 * TODO: we could cache the index so that we can avoid the copy of arrays
 */

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val cache = mutableMapOf<Int, Int>()
    for (i in inorder.indices) {
        cache[inorder[i]] = i
    }
    fun buildTreeByRange(start: Int, end: Int): TreeNode? {
        if (start > end) return null
        var rootVal: Int? = null
        for (i in preorder.indices) {
            for (j in start..end) {
                if (preorder[i] == inorder[j] && rootVal == null) {
                    rootVal = inorder[j]
                }
            }
            if (rootVal != null) {
                break
            }
        }
        val root = TreeNode(rootVal!!)
        val mid = cache[rootVal]!!
        root.left = buildTreeByRange(start, mid - 1)
        root.right = buildTreeByRange(mid + 1, end)
        return root
    }
    return buildTreeByRange(0, inorder.lastIndex)
}

