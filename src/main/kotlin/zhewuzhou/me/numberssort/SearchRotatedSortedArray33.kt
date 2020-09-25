package zhewuzhou.me.numberssort

fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        val mid = (start + end) / 2
        val curNum = if ((nums[mid] < nums[0]) == (target < nums[0])) {
            nums[mid]
        } else {
            if (target < nums[0]) {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }
        when (curNum.compareTo(target)) {
            -1 -> start = mid + 1
            1 -> end = mid - 1
            0 -> return mid
        }
    }
    return -1
}

fun searchVersion2(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    when (nums.size) {
        1 -> return if (nums[0] == target) 0 else -1
        2 -> {
            return when (target) {
                nums[0] -> 0
                nums[1] -> 1
                else -> -1
            }
        }
        else -> {
            val pivot = findPivot(nums)
            val lhs = binarySearch(nums.copyOfRange(0, pivot), target)
            return when (lhs != -1) {
                true -> lhs
                false -> {
                    val rhs = binarySearch(nums.copyOfRange(pivot, nums.size), target)
                    if (rhs == -1) -1 else pivot + rhs
                }
            }
        }
    }
}

fun binarySearch(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex
    while (start <= end) {
        val mid = (end + start) / 2
        when (nums[mid].compareTo(target)) {
            1 -> end = mid - 1
            -1 -> start = mid + 1
            0 -> return mid
        }

    }
    return -1
}

fun findPivot(nums: IntArray): Int {
    var mid = (nums.size - 1) / 2
    var lowBound = 0
    var upBound = nums.size - 1
    while (lowBound < upBound) {
        when (nums[mid].compareTo(nums[0])) {
            0 -> return 0
            1 -> {
                if (mid + 1 < nums.size && nums[mid + 1] < nums[mid])
                    return mid + 1
                else
                    lowBound = mid + 1
            }
            -1 -> {
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                    return mid
                else
                    upBound = mid - 1
            }
        }
        mid = (upBound + lowBound + 1) / 2
    }
    return when (mid == nums.size - 1) {
        true -> {
            if (nums[nums.size - 1] > nums[0]) 0 else nums.size - 1
        }
        false -> mid
    }
}
