package heap

class Heap {
    fun minHeap(array: IntArray) {
        val start = array.size / 2
        for (i in start downTo 0) {
            minHeapHelper(array, i, array.size)
        }
        println(array.toList())
        for (i in array.lastIndex downTo 0) {
            swip(array, i, 0)
            minHeapHelper(array, 0, i)
        }
        println(array.toList().reversed())
    }

    fun minHeapHelper(array: IntArray, index: Int, len: Int) {
        var left = 2 * index
        if (left >= len) return
        var min = left
        var right = left + 1
        if (right < len && array[right] < array[min]) {
            min = right
        }
        if (array[min] < array[index]) {
            swip(array, min, index)
            minHeapHelper(array, min, len)
        }
    }

    fun bigHeap(array: IntArray) {
        val start = array.size / 2
        for (i in start downTo 0) {
            bigHeapHelper(array, i, array.size)
        }
        println(array.toList())
        for (i in array.lastIndex downTo 0) {
            swip(array, i, 0)
            bigHeapHelper(array, 0, i)
        }
        println(array.toList())
    }

    fun bigHeapHelper(array: IntArray, index: Int, len: Int) {
        var left = 2 * index
        if (left >= len) return
        var max = left
        var right = left + 1
        if (right < len && array[max] < array[right])
            max = right
        if (array[index] < array[max]) {
            swip(array, index, max)
            bigHeapHelper(array, max, len)
        }
    }

    fun swip(array: IntArray, left: Int, right: Int) {
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
    }
}

fun main() {
    Heap().bigHeap(intArrayOf(2, 1, 3, 4, 5, 63, 21, 4, 0, 3, 9))
    Heap().minHeap(intArrayOf(2, 1, 3, 4, 5, 63, 21, 4, 0, 3, 9))
}