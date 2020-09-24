package zhewuzhou.me.leetcode60

import zhewuzhou.me.string.allList

fun permute(nums: IntArray): List<List<Int>> =
    allList(nums.size)
        .map { indexList -> indexList.map { nums[it] } }
        .distinct()
