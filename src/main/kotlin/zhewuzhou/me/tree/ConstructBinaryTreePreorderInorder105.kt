package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

/**
 * 1. The 1st element should be root from pre-order
 * 2. Then we should know the left/right according to in-order
 * 3. No duplication in nodes
 */

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val cache = mutableMapOf<Int, Int>()
    for (i in inorder.indices) {
        cache[inorder[i]] = i
    }
    fun buildTreeByRange(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart > preEnd || inStart > inEnd) return null
        val rootVal = preorder[preStart]
        val root = TreeNode(rootVal)
        val inRoot = cache[rootVal]!!
        val numOfLeft = inRoot - inStart
        root.left = buildTreeByRange(preStart + 1, preStart + numOfLeft, inStart, inRoot - 1)
        root.right = buildTreeByRange(preStart + numOfLeft + 1, preEnd, inRoot + 1, inEnd)
        return root
    }
    return buildTreeByRange(0, preorder.lastIndex, 0, inorder.lastIndex)
}

