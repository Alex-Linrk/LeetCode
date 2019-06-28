package sort

class QuickSort {
    fun sort(array: IntArray, left: Int, right: Int) {
        if (left > right) return
        val position = {
            val mid = array[left]
            var cpLeft = left
            var cpRight = right
            while (cpLeft != cpRight) {
                while (array[cpRight] >= mid && cpLeft < cpRight) {
                    cpRight--
                }
                while (array[cpLeft] <= mid && cpLeft < cpRight) {
                    cpLeft++
                }
                if (cpLeft < cpRight) {
                    swip(array, cpLeft, cpRight)
                }
            }
            swip(array, cpLeft, left)
            cpLeft
        }
        val mid = position()
        sort(array, left, mid - 1)
        sort(array, mid + 1, right)
        println(array.toList())
    }

    fun swip(array: IntArray, left: Int, right: Int) {
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
    }
}

fun main() {
    val array = intArrayOf(5, 5, 3, 4, 4, 2, 2, 3, 1, 1, 3)
    QuickSort().sort(array, 0, array.lastIndex)
}