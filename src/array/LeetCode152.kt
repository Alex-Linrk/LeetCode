package array

import kotlin.math.max
import kotlin.math.truncate

class LeetCode152 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var max = nums[0]
        var min = nums[0]
        var res = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] < 0) {
                val tmp = max
                max = min
                min = tmp
            }
            max = max(max * nums[i], nums[i])
            min = min(min * nums[i], nums[i])
            res = max(max, res)
        }
        return res
    }

    fun max(a: Int, b: Int) = if (a > b) a else b
    fun min(a: Int, b: Int) = if (a > b) b else a
}

fun main() {
    println(
        LeetCode152().maxProduct(intArrayOf(2, 3, -2, 4))
    )
}