package zhewuzhou.me.linkedlist

import zhewuzhou.me.linkedlist.ListNode

fun mergeTwoLists(left: ListNode?, right: ListNode?): ListNode? {
    val dummy: ListNode? = ListNode(1)
    var cur = dummy
    var lh = left
    var rh = right
    while (lh != null || rh != null) {
        val lv = lh?.`val` ?: Int.MAX_VALUE
        val rv = rh?.`val` ?: Int.MAX_VALUE
        when (lv.compareTo(rv)) {
            -1 -> {
                cur?.next = lh
                lh = lh?.next
            }
            else -> {
                cur?.next = rh
                rh = rh?.next
            }
        }
        cur = cur?.next
    }
    return dummy?.next
}
