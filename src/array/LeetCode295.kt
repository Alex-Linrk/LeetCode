package array

import kotlin.math.min

/**
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 *例如，
 *
 *[2,3,4] 的中位数是 3
 *
 *[2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 *设计一个支持以下两种操作的数据结构：
 *
 *void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *double findMedian() - 返回目前所有元素的中位数。
 *示例：
 *
 *addNum(1)
 *addNum(2)
 *findMedian() -> 1.5
 *addNum(3)
 *findMedian() -> 2
 *进阶:
 *
 *如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 *如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
class MedianFinder() {
    val list = mutableListOf<Int>()
    /** initialize your data structure here. */

    fun addNum(num: Int) {
        if (list.isEmpty() || list.last() < num) {
            list.add(num)
            return
        }
        if (list.first() > num) {
            list.add(0, num)
            return
        }
        list.add(midFind(list.toIntArray(), num), num)
    }

    fun findMedian(): Double {
        val size = list.size
        return when {
            size == 0 -> 0.0
            size % 2 == 0 -> (list[size / 2] + list[list.size / 2 - 1]) / 2.0
            else -> list[list.size / 2].toDouble()
        }
    }

    fun midFind(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }
}


fun main() {
    val mid = MedianFinder()
    mid.addNum(0)
    mid.addNum(2)
    mid.addNum(1)
    mid.addNum(3)
    mid.addNum(2)
    mid.addNum(0)
    mid.addNum(4)
    mid.addNum(3)
    mid.addNum(2)
    mid.addNum(1)
    println(mid.list)
}
