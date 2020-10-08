package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

class ConstructBinaryTreeInorderPostorder106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val cache = mutableMapOf<Int, Int>()
        for (i in inorder.indices) {
            cache[inorder[i]] = i
        }
        fun build(postStart: Int, postEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
            if (postStart > postEnd || inStart > inEnd) return null
            val rootVal = postorder[postEnd]
            val root = TreeNode(rootVal)
            val inRoot = cache[rootVal]!!
            val nodesRight = inEnd - inRoot
            root.left = build(postStart, postEnd - nodesRight - 1, inStart, inRoot - 1)
            root.right = build(postEnd - nodesRight, postEnd - 1, inRoot + 1, inEnd)
            return root
        }
        return build(0, postorder.lastIndex, 0, inorder.lastIndex)
    }
}
