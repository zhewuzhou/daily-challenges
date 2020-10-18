package zhewuzhou.me.leetcode200


fun reverseBits(n: Int): Int {
    var num = n
    if (num == 0) return 0
    var result = 0
    for (i in 0..31) {
        result = result shl 1
        if (num and 1 == 1) result++
        num = num shr 1
    }
    return result
}
