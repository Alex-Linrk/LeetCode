package array

/**
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *示例 1:
 *
 *输入: nums = [1,1,1,2,2,3], k = 2
 *输出: [1,2]
 *示例 2:
 *
 *输入: nums = [1], k = 1
 *输出: [1]
 *说明：
 *
 *你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
class LeetCode347 {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        if (nums.isEmpty()) return emptyList()
        if (nums.size == k) return nums.toList()
        val map = mutableMapOf<Int, Int>()
        for (word in nums) {
            if (map.containsKey(word)) {
                map[word] = map[word]!! + 1
            } else {
                map[word] = 1
            }
        }
        val start = map.size / 2
        val nodes = map.toList()
        val heaps = Array(map.size) {
            Node(nodes[it].first, nodes[it].second)
        }
        for (index in start downTo 0) {
            maxHeapify(heaps, index, heaps.lastIndex)
        }
        val list = mutableListOf<Int>()
        var item = 0
        while (item < k) {
            list.add(heaps[0].value)
            swip(heaps, 0, heaps.lastIndex - item)
            item++
            maxHeapify(heaps, 0, heaps.lastIndex - item)

        }
        return list
    }

    fun maxHeapify(heaps: Array<Node>, index: Int, len: Int) {
        val left = index * 2
        val right = left + 1
        var max = left
        if (left > len) return
        if (right <= len && heaps[left].count < heaps[right].count) {
            max = right
        }
        if (heaps[max].count > heaps[index].count) {
            swip(heaps, max, index)
            maxHeapify(heaps, max, len)
        }
    }

    fun swip(heaps: Array<Node>, left: Int, right: Int) {
        val temp = heaps[left]
        heaps[left] = heaps[right]
        heaps[right] = temp
    }

}

data class Node(val value: Int, val count: Int)

fun main() {
    println(
        LeetCode347().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
    )
    println(
        LeetCode347().topKFrequent(intArrayOf(1), 1)
    )
}