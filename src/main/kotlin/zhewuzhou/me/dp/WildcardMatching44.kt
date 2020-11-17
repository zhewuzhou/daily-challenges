package zhewuzhou.me.dp

/*
1. Come up with recursive solution first
2. Change it to cacheable metrics[][]
 */

fun isMatch44Recur(s: String, p: String): Boolean {
    val caches = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun match(s: String, p: String, si: Int, pi: Int): Boolean {
        if (pi == p.length) return si == s.length
        val key = Pair(si, pi)
        if (!caches.containsKey(key)) {
            caches[key] = when (p[pi]) {
                '*' -> {
                    (si < s.length && match(s, p, si + 1, pi))
                        || match(s, p, si, pi + 1)
                }
                else -> {
                    si < s.length
                        && charMatch44(s[si], p[pi])
                        && match(s, p, si + 1, pi + 1)
                }
            }
        }
        return caches[key]!!
    }
    return match(s, p, 0, 0)
}


fun isMatch44DP(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) { BooleanArray(p.length + 1) }
    dp[0][0] = true
    for (pi in p.indices) {
        if (p[pi] == '*') {
            dp[0][pi + 1] = true
        } else {
            break
        }
    }
    for (pi in p.indices) {
        for (si in s.indices) {
            when (p[pi] == '*') {
                true -> {
                    dp[si + 1][pi + 1] = dp[si + 1][pi] || dp[si][pi + 1]
                }
                false -> {
                    if (charMatch44(s[si], p[pi])) {
                        dp[si + 1][pi + 1] = dp[si][pi]
                    }
                }
            }
        }
    }
    return dp[s.length][p.length]
}

private fun charMatch44(s: Char, p: Char): Boolean =
    when (p == '?') {
        true -> true
        false -> s == p
    }
