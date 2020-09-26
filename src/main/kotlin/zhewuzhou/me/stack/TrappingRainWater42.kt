package zhewuzhou.me.stack

import java.util.*

/*
Case driven:
1 0 1 should works
1 0 1 0 1 should works
More complex case should works

This is really a great question such that it can be solve in:
1. DP
2. Stack
3. 2 Pointers/Sliding window
 */

fun trapDP(height: IntArray): Int {
    val rightMax = mutableMapOf<Int, Int>()
    val leftMax = mutableMapOf<Int, Int>()
    var water = 0
    for (i in 1 until height.lastIndex) {
        leftMax[i] = Math.max(height[i - 1], (leftMax[i - 1] ?: 0))
        val rightIndex = height.lastIndex - i
        rightMax[rightIndex] = Math.max(height[rightIndex + 1], (rightMax[rightIndex + 1] ?: 0))
    }
    for (i in 1 until height.lastIndex) {
        water += Math.max(Math.min(rightMax[i]!!, leftMax[i]!!) - height[i], 0)
    }
    return water
}

fun trapStack(height: IntArray): Int {
    val stack: Stack<Int> = Stack()
    var totalWater = 0
    for (right in height.indices) { // Maintain heights in stack are decreasing
        while (!stack.isEmpty() && height[stack.peek()] < height[right]) {
            val bottom = stack.pop()
            if (stack.isEmpty()) {
                break
            }
            val left = stack.peek()
            val water: Int = (Math.min(height[right], height[left]) - height[bottom]) * (right - left - 1)
            totalWater += water
        }
        stack.push(right)
    }
    return totalWater
}

fun trap(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var result = 0
    var leftMax = 0
    var rightMax = 0
    while (left < right) {
        when (height[left].compareTo(height[right])) {
            1 -> {
                rightMax = Math.max(rightMax, height[right])
                result += rightMax - height[right]
                right -= 1
            }
            else -> {
                leftMax = Math.max(leftMax, height[left])
                result += leftMax - height[left]
                left += 1
            }
        }
    }
    return result
}
