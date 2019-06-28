package array

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *示例 1:
 *
 *输入: [1,2,3,4,5,6,7] 和 k = 3
 *输出: [5,6,7,1,2,3,4]
 *解释:
 *向右旋转 1 步: [7,1,2,3,4,5,6]
 *向右旋转 2 步: [6,7,1,2,3,4,5]
 *向右旋转 3 步: [5,6,7,1,2,3,4]
 *示例 2:
 *
 *输入: [-1,-100,3,99] 和 k = 2
 *输出: [3,99,-1,-100]
 *解释:
 *向右旋转 1 步: [99,-1,-100,3]
 *向右旋转 2 步: [3,99,-1,-100]
 *说明:
 *
 *尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *要求使用空间复杂度为 O(1) 的原地算法。
 */
class LeetCode189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        for (i in 1..k) {
            val temp = nums[nums.lastIndex]
            for (i in nums.lastIndex downTo 1) {
                nums[i] = nums[i - 1]
            }
            nums[0] = temp
        }
        println(nums.toList())
    }

    fun rotate2(nums: IntArray, k: Int) {
        for (x in 0 until k) {
            for (y in nums.lastIndex.downTo(x + 1)) {
                val temp = nums[y]
                nums[y] = nums[y - 1]
                nums[y - 1] = temp
            }
        }
        println(nums.toList())
    }
}

fun main() {
    LeetCode189().rotate2(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2)
}