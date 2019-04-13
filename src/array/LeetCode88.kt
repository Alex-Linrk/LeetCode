package array

/**
 * 合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
思路：
因为是两个有序数组，为了避免移动数组的麻烦，从后往前比较，
将有效的最大值放在最后面，并向前移动并继续前面的过程，完成整个过程
并且要判断是num2是有比较头，如果没有则将num2直接放放到数组头
 */
class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var big = m
        var other = n
        var p = big-- + other-- - 1
        while (big >= 0 && other >= 0) {
            nums1[p--] = if (nums1[big] > nums2[other]) nums1[big--] else nums2[other--]
        }

        while (other >= 0) {
            nums1[p--] = nums2[other--]
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    Solution88().merge(nums1, 3, nums2 = nums2, n = 3)
    println(nums1.toList())


}