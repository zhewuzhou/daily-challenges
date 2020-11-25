package zhewuzhou.me.dp

/**
 * 1. Range of num [1, 10000].
 * 2. Range of dresses in machine [0, 1e5].
 */

/**
 * 1. The total gain/lose between each two machines. For example in your sample data the total gain/lose between machine 1
 *   and 2 are (-4)+(-4)=-8 and 7+1=8. This means in order to make a balance, there should be at least 8 items move from
 *   right to left between machine 1 and 2. In your algorithm this is done by Math.abs(cnt)
 * 2. The max of each individual gain/lose if positive. The problem says "pass one dress of each washing machine to one of"
 *   which means if the gain/lose is negative, there could be at most two items moved in because there are only at most two
 *   neighbors. But if gain/lose is positive, only one can be moved out so this sets the lower bound.
 */
fun findMinMoves(machines: IntArray): Int {
    val sum = machines.sum()
    if (sum < machines.size ||
            sum % machines.size != 0 ||
            machines.any { it < 0 }) {
        return -1
    }

    val target = sum / machines.size
    var res = 0
    var cnt = 0
    for (n in machines) {
        cnt += n - target
        res = Math.max(Math.max(cnt, res), n - target)
    }

    return res
}