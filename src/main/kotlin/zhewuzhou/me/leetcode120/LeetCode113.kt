package zhewuzhou.me.leetcode120

import zhewuzhou.utils.TreeNode

fun flatten(root: TreeNode?) {
    flatten(root, null)
}

private fun flatten(root: TreeNode?, pre: TreeNode?): TreeNode? {
    var pre = pre
    if (root == null) return pre
    pre = flatten(root.right, pre)
    pre = flatten(root.left, pre)
    root.right = pre
    root.left = null
    pre = root
    return pre
}
