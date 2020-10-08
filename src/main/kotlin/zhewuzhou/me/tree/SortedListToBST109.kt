package zhewuzhou.me.tree

import zhewuzhou.utils.ListNode
import zhewuzhou.utils.TreeNode

fun pickNthElement(head: ListNode?, n: Int): Pair<ListNode?, Int> {
    var pc = 1
    var cur = head
    var pre: ListNode? = null
    while (pc <= n && cur != null) {
        pre = cur
        cur = cur.next
        pc += 1
    }
    val nh = cur?.next
    cur?.next = null
    pre?.next = null
    return Pair(nh, cur?.`val`!!)
}

private fun listNodeLength(head: ListNode?): Int {
    var nh = head
    var length = 1
    while (nh?.next != null) {
        nh = nh.next
        length += 1
    }
    return length
}

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    val length = listNodeLength(head)
    if (length == 1) return TreeNode(head.`val`)
    val (right, rootVal) = pickNthElement(head, length / 2)
    val root = TreeNode(rootVal)
    root.left = sortedListToBST(head)
    if (right != null) root.right = sortedListToBST(right)
    return root
}
