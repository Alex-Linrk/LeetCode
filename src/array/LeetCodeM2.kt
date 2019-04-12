package array

/**
 * 求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

摩尔投票法 Moore Voting，需要 O(n) 的时间和 O(1) 的空间，比前一种方法更好。这种投票法先将第一个数字假设为过半数，然后把计数器设为1，比较下一个数和此数是否相等，若相等则计数器加一，反之减一。然后看此时计数器的值，若为零，则将下一个值设为候选过半数。以此类推直到遍历完整个数组，当前候选过半数即为该数组的过半数。
 */
class SolutionM2 {
    fun majorityElement(nums: IntArray): Int {
        var times = 0
        var result = nums[0]
        for (num in nums) {
            if (times == 0) {
                result = num
                times++
            } else {
                if (num == result) {
                    times++
                } else {
                    times--
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(SolutionM2().majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}