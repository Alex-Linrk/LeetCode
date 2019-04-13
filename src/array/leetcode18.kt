package leecode

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。
示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]
 */
class leetcode18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.size < 4) return result
        nums.sort()
        for (i in 0..nums.size - 4) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            for (j in i + 1..nums.size - 3) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue
                var low = j + 1
                var height = nums.size - 1
                while (low < height) {
                    val sum = nums[i] + nums[j] + nums[low] + nums[height]
                    when {
                        sum == target -> {
                            val find = listOf(nums[i], nums[j], nums[low], nums[height])
                            result.add(find)
                            while (low < height && nums[low] == nums[low + 1]) low++
                            low++
                            while (height > low && nums[height - 1] == nums[height]) height--
                            height--
                        }
                        sum > target -> {
                            height--
                        }
                        sum < target -> {
                            low++
                        }
                    }
                }
            }
        }
        return result
    }
}

/**
 * [-1,0,-5,-2,-2,-4,0,1,-2]
-9
 */
fun main() {
    val nums = intArrayOf(-1, 0, -5, -2, -2, -4, 0, 1, -2)
    val target = -9
    val result = leetcode18().fourSum(nums = nums, target = target)
    println(result)
}