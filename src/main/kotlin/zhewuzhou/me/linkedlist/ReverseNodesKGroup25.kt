package zhewuzhou.me.linkedlist

import zhewuzhou.utils.ListNode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var curSecHead = head
    var nextSecHead = curSecHead
    var count = 0
    while (nextSecHead != null && count != k) {
        nextSecHead = nextSecHead.next
        count++
    }
    if (count == k) {
        nextSecHead = reverseKGroup(nextSecHead, k)
        while (count-- > 0) {
            val tmp = curSecHead!!.next
            curSecHead.next = nextSecHead
            nextSecHead = curSecHead
            curSecHead = tmp
        }
        curSecHead = nextSecHead
    }
    return curSecHead
}
