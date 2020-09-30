package zhewuzhou.me.linkedlist

import zhewuzhou.utils.ListNode


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return head
    var cur = head
    var length = 0
    while (cur != null) {
        length += 1
        cur = cur.next
    }
    var gap = k % length
    if (gap == 0) return head
    var fast = head
    var slow = head
    while (gap > 0) {
        fast = fast?.next
        gap -= 1
    }
    while (fast?.next != null) {
        fast = fast.next
        slow = slow?.next
    }
    val newHead = slow?.next
    slow?.next = null
    fast?.next = head
    return newHead
}
