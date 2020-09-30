package zhewuzhou.me.linkedlist

import zhewuzhou.utils.ListNode

fun swapPairs(head: ListNode?): ListNode? {
    var left = head
    var right = head?.next
    var preNext: ListNode? = null
    val newHead = when (right == null) {
        true -> left
        false -> right
    }
    while (left != null && right != null) {
        val newNext = right.next
        right.next = left
        left.next = newNext
        when (preNext == null) {
            true -> preNext = left
            false -> {
                preNext.next = right
                preNext = left
            }
        }
        left = newNext
        right = left?.next
    }
    return newHead
}
