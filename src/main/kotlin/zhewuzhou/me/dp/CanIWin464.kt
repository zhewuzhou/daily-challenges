package zhewuzhou.me.dp

import java.util.*


/*
My Broken solution:
1. How to express the second player will try best to stop me?
2. How to cache the sub problem?
 */
fun canIWinBroken(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    val pool = TreeSet((1..maxChoosableInteger).toList())
    fun roundRun(pool: TreeSet<Int>, curSum: Int, isPlay1: Boolean): Boolean {
        if (pool.ceiling(desiredTotal - curSum) != null) {
            return isPlay1
        }
        val possibles = pool.toTypedArray()
        for (p in possibles) {
            pool.remove(p)
            if (!roundRun(pool, curSum + p, !isPlay1)) {
                return true
            }
            pool.add(p)
        }
        return false
    }
    return roundRun(pool, 0, true)
}

fun canIWin(maxChoose: Int, total: Int): Boolean {
    if ((1 + maxChoose) * maxChoose / 2 < total) {
        return false
    }
    val state = IntArray(maxChoose + 1)
    return canWin(state, total, mutableMapOf())
}

fun canWin(state: IntArray, total: Int, hmap: MutableMap<String, Boolean>): Boolean {
    val key = Arrays.toString(state)
    if (hmap.containsKey(key)) {
        return hmap[key]!!
    }
    for (i in 1 until state.size) {
        if (state[i] == 0) {
            state[i] = 1
            /*
            1. total-i <= 0 means I win
            2. !canWin(state, total - i, hmap) means player2 can not win,
               player2 will try to explore all possible way to win according to code
             */
            if (total - i <= 0 || !canWin(state, total - i, hmap)) {
                hmap[key] = true
                state[i] = 0
                return true
            }
            state[i] = 0
        }
    }
    hmap[key] = false
    return false
}
