package array

import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

/**
 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
在真实的面试中遇到过这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shuffle-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution(nums: IntArray) {
    val original = nums.clone()
    var nums = nums
    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        nums = original.clone()
        return nums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (index in 0 .. nums.lastIndex) {
            val other = java.util.concurrent.ThreadLocalRandom.current().nextInt(index, nums.lastIndex+1)
            println(other)
            swip(nums, other, index)
        }
        return nums
    }

    fun swip(nums: IntArray, x: Int, y: Int) {
        val temp = nums[x]
        nums[x] = nums[y]
        nums[y] = temp
    }


}

fun main() {
    val solution = Solution(intArrayOf(1,2,3))
    println(solution.shuffle().toList())
    println(solution.reset().toList())
    println(solution.shuffle().toList())
}