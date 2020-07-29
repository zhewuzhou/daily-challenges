package zhewuzhou.me.dp

/*
Stones num should be 2 until 1100
Stone num is 0..
1st always 0
1st Jump is 1
k -> next should be k-1..k+1
forward only
 */
fun canCrossRecur(stones: IntArray): Boolean {
    if (stones.isEmpty()) return false
    val path = mutableMapOf<Int, MutableSet<Int>>()
    for (i in stones.indices) {
        path[stones[i]] = mutableSetOf()
    }
    path[stones[0]]!!.add(1)
    for (i in stones.indices) {
        val cur = stones[i]
        for (k in path[cur]!!) {
            val reach = cur + k
            if (reach == stones.last()) {
                return true
            }
            if (path.containsKey(reach)) {
                val steps = path[reach]!!
                if (k - 1 > 0) steps.add(k - 1)
                steps.add(k)
                steps.add(k + 1)
            }
        }
    }
    return false
}


fun canCross(stones: IntArray): Boolean {
    if (stones.isEmpty()) return false
    val totalStores = stones.size
    val matrix = Array(totalStores) { BooleanArray(totalStores + 1) }
    if (stones[1] == 1) matrix[0][1] = true
    for (i in 1 until totalStores) {
        for (j in i - 1 downTo 0) {
            val k = stones[i] - stones[j]
            if (k <= totalStores && matrix[j][k]) {
                if (i == stones.lastIndex) return true
                if (k - 1 > 0) matrix[i][k - 1] = true
                matrix[i][k] = true
                matrix[i][k + 1] = true
            }
        }
    }
    return false
}
