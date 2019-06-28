package array

import java.util.*

class LeetCode31 {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.isEmpty() || nums.size == 1) return
        var maxIndex = nums.lastIndex
        for (k in nums.lastIndex - 1 downTo 0) {
            if (nums[k] < nums[maxIndex]) {
                val temp = nums[k]
                nums[k] = nums[maxIndex]
                nums[maxIndex] = temp
                return
            }
        }
        Arrays.sort(nums)
    }
}

fun main() {
    LeetCode31().nextPermutation(intArrayOf(1, 2, 3))
    LeetCode31().nextPermutation(intArrayOf(3, 2, 1))
    LeetCode31().nextPermutation(intArrayOf(1, 1, 5))
    LeetCode31().nextPermutation(intArrayOf(1, 1, 3,2))
    LeetCode31().nextPermutation(intArrayOf(1, 3, 2))
}
