package heap

/**
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 *返回滑动窗口最大值。
 *
 *示例:
 *
 *输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *输出: [3,3,5,5,6,7]
 *解释:
 *
 *滑动窗口的位置                最大值
 *---------------               -----
 *[1  3  -1] -3  5  3  6  7       3
 *1 [3  -1  -3] 5  3  6  7       3
 *1  3 [-1  -3  5] 3  6  7       5
 *1  3  -1 [-3  5  3] 6  7       5
 *1  3  -1  -3 [5  3  6] 7       6
 *1  3  -1  -3  5 [3  6  7]      7
 *注意：
 *
 *你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 *进阶：
 *
 *你能在线性时间复杂度内解决此题吗？
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf()
        var left: Int
        val result = mutableListOf<Int>()
        left = getMaxIndex(nums, 0, k)
        result.add(nums[left])
        for (i in k until nums.size) {
            if (nums[i] >= nums[left]) {
                left = i
            } else if (left + k - 1 < i) {
                left = getMaxIndex(nums, left+1, k)
            }
            result.add(nums[left])
        }
        return result.toIntArray()
    }

    private fun getMaxIndex(nums: IntArray, left: Int, k: Int): Int {
        var position = left
        var max = nums[position]
        var right = if(left+k>nums.size) nums.size else left+k
        for (x in left until right) {
            if (nums[x] >= max) {
                position = x
                max = nums[position]
            }
        }
        return position
    }
}

/**
 * [9,10,9,-7,-4,-8,2,-6]
 * 5
 */
fun main() {
    println(
        LeetCode239().maxSlidingWindow(
            intArrayOf(9,10,9,-7,-4,-8,2,-6), 5
        ).toList()
    )
    println(
        LeetCode239().maxSlidingWindow(
            intArrayOf(1,2,3,4,5,6,7,8), 3
        ).toList()
    )
}

