package heap

import kotlin.math.max

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 *请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 *示例:
 *
 *matrix = [
 *[ 1,  5,  9],
 *[10, 11, 13],
 *[12, 13, 15]
 *],
 *k = 8,
 *
 *返回 13。
 *说明:
 *你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */
class LeetCode378 {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val heapArray = IntArray(matrix[0].size * matrix.size)
        for (y in 0 until matrix.size) {
            for (x in 0 until matrix[y].size) {
                heapArray[matrix[0].size * y + x] = matrix[y][x]
            }
        }
        val begin = heapArray.lastIndex / 2
        for (start in begin downTo 0)
            maxHeapify(heapArray, start, heapArray.lastIndex)
        var size = 0
        while (size < heapArray.size) {
            swip(heapArray, 0, heapArray.lastIndex - size)
            size++
            maxHeapify(heapArray, 0, heapArray.lastIndex - size)
        }
        return heapArray[k - 1]
    }

    fun maxHeapify(nums: IntArray, index: Int, len: Int) {
        val left = index * 2
        val right = left + 1
        var max = left
        if (left > len) return
        if (right <= len && nums[left] < nums[right]) {
            max = right
        }
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

/**
 * [[1,3,5],[6,7,12],[11,14,14]]
1
[[1,5,9],[10,11,13],[12,13,15]]
 */
fun main() {
    println(
        LeetCode378().kthSmallest(
            arrayOf(
                intArrayOf(1, 3, 5),
                intArrayOf(6, 7, 12),
                intArrayOf(11, 14, 14)
            )
            , 1
        )
    )
    println(
        LeetCode378().kthSmallest(
            arrayOf(
                intArrayOf(1,5,9),
                intArrayOf(10,11,13),
                intArrayOf(12,13,15)
            )
            , 8
        )
    )
}