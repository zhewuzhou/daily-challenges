package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

/**
 * 1. The 1st element should be root from pre-order
 * 2. Then we should know the left/right according to in-order
 * 3. No duplication in nodes
 * TODO: we could cache the index so that we can avoid the copy of arrays
 */

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty()) return null
    if (preorder.size == 1) return TreeNode(preorder[0])
    val root = TreeNode(preorder[0])
    val mid = inorder.indexOf(root.`val`)
    val inLeft = inorder.copyOfRange(0, mid)
    val inRight = inorder.copyOfRange(mid + 1, inorder.size)
    root.left = buildTree(preorder.filter { inLeft.contains(it) }.toIntArray(), inLeft)
    root.right = buildTree(preorder.filter { inRight.contains(it) }.toIntArray(), inRight)
    return root
}

