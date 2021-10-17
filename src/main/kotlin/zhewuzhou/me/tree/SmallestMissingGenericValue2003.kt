package zhewuzhou.me.tree

import java.util.*

// TODO: 2021/10/17 stop and all of the other is 1 when smallest path is finished
// TODO: 2021/10/17 more cause for handle the edge cases
fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
    val isEmpty = parents.isEmpty() || nums.isEmpty()
    val hasWrongSize = parents.size != nums.size || nums.distinct().size != nums.size
    if (isEmpty || hasWrongSize) {
        return intArrayOf();
    }
    //We only care about the path of 1, and all other paths have value of 1
    val smallPath = calculateSmallestPath(nums, parents)
    if (smallPath.isEmpty()) {
        return IntArray(nums.size) { 1 }
    }

    //breadth travel tree to calculate all the smallest value
    val queue = LinkedList<Int>()
    val childrenMap = calculateChildrenMap(parents)
    queue.addFirst(0)
    val allTreeValue = nums.toMutableSet()
    val result = TreeMap<Int, Int>()
    while (!queue.isEmpty()) {
        val currentNode = queue.poll()
        for (m in 2..allTreeValue.size) {
            if (!allTreeValue.contains(m)) {
                result[currentNode] = m
            }
        }
        if (!result.contains(currentNode)) {
            result[currentNode] = allTreeValue.size + 1
        }
        allTreeValue.remove(nums[currentNode])

        if (childrenMap.contains(currentNode)) {
            val brothers = childrenMap[currentNode]!!
            for (b in brothers) {
                if (smallPath.contains(b)) {
                    queue.add(b)
                } else {
                    allTreeValue.removeAll(getNodeValues(b, childrenMap, nums))
                    val nodeIndexes = getNodeIndexes(b, childrenMap)
                    for (i in nodeIndexes) {
                        result[i] = 1
                    }
                }
            }
        }
    }

    return result.values.toIntArray()
}

private fun calculateSmallestPath(
    nums: IntArray,
    parents: IntArray
): MutableSet<Int> {
    val oneIndex = nums.indexOf(1)
    val smallPath = mutableSetOf<Int>()
    if (-1 != oneIndex) {
        var current = oneIndex
        while (current != -1) {
            smallPath.add(current)
            current = parents[current]
        }
    }
    return smallPath
}

private fun getNodeIndexes(cur: Int, childrenMap: MutableMap<Int, MutableSet<Int>>): MutableSet<Int> {
    val queue = LinkedList<Int>()
    queue.add(cur)
    val result = mutableSetOf(cur)
    while (queue.isNotEmpty()) {
        val curIndex = queue.poll()
        if (childrenMap.contains(curIndex)) {
            val children = childrenMap[curIndex]!!
            result.addAll(children)
            queue.addAll(children)
        }
    }
    return result
}

private fun getNodeValues(
    cur: Int,
    childrenMap: MutableMap<Int, MutableSet<Int>>,
    nums: IntArray
): MutableSet<Int> {
    val queue = LinkedList<Int>()
    queue.add(cur)
    val result = mutableSetOf(nums[cur])
    while (queue.isNotEmpty()) {
        val curIndex = queue.poll()
        result.add(nums[curIndex])
        if (childrenMap.contains(curIndex)) {
            queue.addAll(childrenMap[curIndex]!!)
        }
    }
    return result
}

private fun calculateChildrenMap(parents: IntArray): TreeMap<Int, MutableSet<Int>> {
    val childrenMap = TreeMap<Int, MutableSet<Int>>()
    for (i in parents.indices) {
        if (childrenMap.contains(parents[i])) {
            childrenMap[parents[i]]!!.add(i)
        } else {
            childrenMap[parents[i]] = mutableSetOf(i)
        }
    }
    return childrenMap
}