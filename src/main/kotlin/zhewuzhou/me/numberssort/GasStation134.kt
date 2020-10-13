package zhewuzhou.me.numberssort

/**
 * Still not fast enough solution
 */

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    for (start in gas.indices) {
        var cur = start
        var tank = gas[start]
        var visited = 0
        while (visited < gas.size) {
            val before = cur
            cur = (cur + 1) % gas.size
            tank -= cost[before]
            if (tank < 0) {
                break
            }
            tank += gas[cur]
            visited += 1
        }
        if (visited == gas.size) {
            return start
        }
    }
    return -1
}

fun canCompleteCircuitFast(gas: IntArray, cost: IntArray): Int {
    var sum = 0
    var subSum = 0
    var start = 0
    for (i in gas.indices) {
        subSum += gas[i] - cost[i]
        if (subSum < 0) {
            sum += subSum
            subSum = 0
            start = i + 1
        }
    }
    sum += subSum
    return if (sum < 0) -1 else (start % gas.size)
}
