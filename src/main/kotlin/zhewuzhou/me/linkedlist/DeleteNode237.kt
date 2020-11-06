package zhewuzhou.me.linkedlist

import zhewuzhou.utils.ListNode

fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val`!!
    val nn = node.next?.next
    node.next?.next = null
    node.next = nn
}

