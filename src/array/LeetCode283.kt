package array

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode283 {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        val index = nums.lastIndex
        var count = 0
        for (last in index downTo 0) {
            if (nums[last] != 0) continue
            for (swip in last until index - count) {
                nums[swip] = nums[swip + 1]
            }
            nums[nums.lastIndex - count] = 0
            count++
        }
        println(nums.toList())
    }
}

fun main() {
    LeetCode283().moveZeroes(nums = intArrayOf(0, 1, 0, 3, 12))
    LeetCode283().moveZeroes(nums = intArrayOf(0, 1,6,7,0,5,6, 0, 3, 12))
}