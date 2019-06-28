package array

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *示例 1:
 *
 *输入: [3,2,1,5,6,4] 和 k = 2
 *输出: 5
 *示例 2:
 *
 *输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *输出: 4
 *说明:
 *
 *你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var item = k
        var x = nums.lastIndex
        while (item > 0) {
            var swip = false
            for (y in 0 until x) {
                if (nums[y] > nums[y + 1]) {
                    swip(nums, y, y + 1)
                    swip = true
                }
            }
            if (swip.not()) {
                break
            }
            item--
            x--
        }
        println(nums.toList())
        return nums[nums.size - k]
    }

    fun findKthLargestByHeap(nums: IntArray, k: Int): Int {
        val begin = nums.lastIndex.shr(1)
        for (start in begin downTo 0)
            maxHeapify(nums, start, nums.lastIndex)
        var index = 0
        println(nums.toList())
        while (index < k) {
            swip(nums, 0, nums.lastIndex - index)
            index++
            maxHeapify(nums, 0, nums.lastIndex - index)
        }
        println(nums.toList())
        return nums[nums.size - k]
    }

    fun maxHeapify(nums: IntArray, index: Int, len: Int) {
        val left = index.shl(1) + 1
        val right = left + 1
        var max = left
        if (left > len) return
        if (right <= len && nums[right] > nums[left])
            max = right
        if (nums[max] > nums[index]) {
            swip(nums, max, index)
            maxHeapify(nums, max, len)
        }
    }

    fun swip(nums: IntArray, x: Int, y: Int) {
        val temp = nums[x]
        nums[x] = nums[y]
        nums[y] = temp
    }
}

fun main() {
    println(
        LeetCode215().findKthLargestByHeap(
            intArrayOf(3, 2, 1, 5, 6, 4),
            2
        )
    )
    println(
        LeetCode215().findKthLargestByHeap(
            intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6),
            4
        )
    )
}