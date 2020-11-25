package zhewuzhou.me.dp

fun findMinMoves(machines: IntArray): Int {
    val sum = machines.sum()
    if (sum < machines.size ||
            sum % machines.size != 0 ||
            machines.any { it < 0 }) {
        return -1
    }
    return 0
}