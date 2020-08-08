package zhewuzhou.me.leetcode300

fun canWinNim(n: Int): Boolean {
    if (n <= 0) return true
    return n % 4 != 0
}
