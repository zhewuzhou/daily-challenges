import zhewuzhou.utils.ListNode

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
    var carry = 0
    var lr1 = l1
    var lr2 = l2
    val dummySum = ListNode(1)
    var cur: ListNode? = dummySum
    while (lr1 != null || lr2 != null) {
        val sum = (lr1?.`val` ?: 0) + (lr2?.`val` ?: 0) + carry
        cur?.next = ListNode(sum % 10)
        cur = cur?.next
        carry = sum / 10
        lr1 = lr1?.next
        lr2 = lr2?.next
    }
    if (carry == 1) {
        cur?.next = ListNode(carry)
    }
    return dummySum.next
}
