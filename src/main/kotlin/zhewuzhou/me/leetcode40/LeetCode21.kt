package zhewuzhou.me.leetcode40

import zhewuzhou.me.linkedlist.ListNode

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var lh = l1
    var rh = l2
    var nh: ListNode? = null
    var nt: ListNode? = null
    while (lh != null || rh !== null) {
        val lv = lh?.`val` ?: Int.MAX_VALUE
        val rv = rh?.`val` ?: Int.MAX_VALUE
        when (lv <= rv) {
            true -> {
                if (nh == null) {
                    nh = lh
                    nt = lh
                } else {
                    nt?.next = lh
                    nt = lh
                }
                lh = lh?.next
            }
            false -> {
                if (nh == null) {
                    nh = rh
                    nt = rh
                } else {
                    nt?.next = rh
                    nt = rh
                }
                rh = rh?.next
            }
        }
    }
    return nh
}
