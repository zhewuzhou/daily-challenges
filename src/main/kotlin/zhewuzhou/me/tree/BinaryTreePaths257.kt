package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

fun binaryTreePaths(root: TreeNode?): List<String> {
    fun searchPaths(node: TreeNode?, cur: String, res: MutableList<String>) {
        if (node != null && node.right == null && node.left == null) {
            res.add(cur)
            return
        }
        if (node?.right != null) {
            searchPaths(node.right, "$cur->${node.right!!.`val`}", res)
        }
        if (node?.left != null) {
            searchPaths(node.left, "$cur->${node.left!!.`val`}", res)
        }
    }

    val result = mutableListOf<String>()
    if (root == null) return listOf()
    searchPaths(root, "${root.`val`}", result)
    return result
}
