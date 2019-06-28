package array

/**
 * 存在重复元素
 *给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * **/
class LeetCode217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false
        var max = nums[0]
        var min = nums[0]
        for (item in nums) {
            max = Math.max(item, max)
            min = Math.min(item, min)
        }
        val dic = max - min
        val intArray = IntArray(dic + 1)
        for (num in nums.withIndex()) {
            intArray[num.value - min]++
            if (intArray[num.value - min] == 2) return true
        }
        return false
    }
}

fun main() {
    println(LeetCode217().containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(LeetCode217().containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(LeetCode217().containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}