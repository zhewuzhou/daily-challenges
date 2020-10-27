package zhewuzhou.me.simple

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var result = m
    for (i in m..n) {
        if (result == 0) break
        else {
            result = result and i
        }
    }
    return result
}
