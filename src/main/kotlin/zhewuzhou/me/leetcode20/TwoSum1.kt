package zhewuzhou.me.leetcode20

import java.util.*


data class TargetFinder(val value: Int, val index: Int) : Comparable<TargetFinder> {
    override fun compareTo(other: TargetFinder): Int {
        return this.value.compareTo(other.value)
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val arr = nums
        .mapIndexed { index, value -> TargetFinder(value, index) }
        .toTypedArray()

    Arrays.sort(arr)

    for (i in arr.indices) {
        val other = arr.binarySearch(TargetFinder(target - arr[i].value, -1), i + 1)
        if (other >= 0) {
            return intArrayOf(arr[i].index, arr[other].index)
        }
    }
    return intArrayOf()
}
