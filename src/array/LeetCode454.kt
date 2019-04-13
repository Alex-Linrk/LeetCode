package leecode

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
class LeetCode454 {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var count: Int = 0
        val map = mutableMapOf<Int, Int>()
        A.forEach { i ->
            B.forEach {
                when {
                    map.containsKey(i + it) ->
                        map[i + it] = map[i + it]!! + 1
                    else -> map[i + it] = 1
                }

            }
        }
        for (i in D) {
            for (j in C) {
                if (map.containsKey(-(i + j))) {
                    count += map[-(i + j)]!!
                }
            }
        }
        return count
    }
}

fun main() {
    val A = intArrayOf(1, 2)
    val B = intArrayOf(-2, -1)
    val C = intArrayOf(-1, 2)
    val D = intArrayOf(0, 2)
    println(LeetCode454().fourSumCount(A, B, C, D))
}