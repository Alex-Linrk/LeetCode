package array

import java.util.*

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
class LeetCode350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) return IntArray(0)
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        if (nums1.last() < nums2.first() || nums1.first() > nums2.last()) return IntArray(0)
        val result = IntArray(Math.min(nums1.size, nums2.size))
        var x = 0
        var y = 0
        var count = 0
        var max = nums1
        var min = nums2
        if (nums1.size < nums2.size) {
            max = nums2
            min = nums1
        }
        while (x < min.size && y < max.size) {
            when {
                min[x] > max[y] -> y++
                min[x] < max[y] -> x++
                else -> {
                    result[count++] = min[x]
                    x++
                    y++
                }
            }
        }
        return result.copyOfRange(0,count)
    }
}

fun main() {
    println(
            LeetCode350().intersect(
                intArrayOf(1, 2, 2, 1),
                intArrayOf(2, 2)
            ).asList()
            )

    println(
        LeetCode350().intersect(
            intArrayOf(4,9,5),
            intArrayOf(9,4,9,8,4)
        ).asList()
    )
}