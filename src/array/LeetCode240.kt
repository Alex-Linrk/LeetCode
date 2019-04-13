package array

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下：

[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
 */
class Solution240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        if (target < matrix[0][0] || target > matrix[matrix.lastIndex][matrix[matrix.lastIndex].lastIndex])
            return false
        var x = matrix[0].lastIndex
        var y = matrix.lastIndex
        while (matrix[y][x] > target) {
            if (x - 1 >= 0) x--
            if (y - 1 >= 0) y--
        }
        if (matrix[y][x] == target) return true
        for (start_y in y + 1..matrix.lastIndex) {
            for (start_x in 0..x) {
                if (matrix[start_y][start_x] == target) return true
            }
        }
        for (start_y in 0..y) {
            for (start_x in x..matrix[0].lastIndex) {
                if (matrix[start_y][start_x] == target) return true
            }
        }
        return false
    }
}

fun main() {
//    val l1 = intArrayOf(1, 4, 7, 11, 15)
//    val l2 = intArrayOf(2, 5, 8, 12, 19)
//    val l3 = intArrayOf(3, 6, 9, 16, 22)
//    val l4 = intArrayOf(10, 13, 14, 17, 24)
//    val l5 = intArrayOf(18, 21, 23, 26, 30)
//    val matrix = arrayOf(l1, l2, l3, l4, l5)
//    println(Solution240().searchMatrix(matrix, 26))
    println(Solution240().searchMatrix(Array(1) { intArrayOf(-1, 3) }, 3))
    println(Solution240().searchMatrix(Array(2) { intArrayOf(it + 1) }, 2))
}