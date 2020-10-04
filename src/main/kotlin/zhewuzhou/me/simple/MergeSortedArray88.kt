package zhewuzhou.me.simple

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for (i in m until (m + n)) {
        nums1[i] = nums2[i - m]
    }
    nums1.sort(0, m + n - 1)
}


