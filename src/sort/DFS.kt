package sort

class DFS {
    fun dsf(n: Int) {
        val array = IntArray(n)
        val book = IntArray(n)
        realDSF(array, book, 1)
    }

    fun realDSF(array: IntArray, bookArray: IntArray, step: Int) {
        if (step == array.size+1) {
            println(array.toList())
            return
        }
        for (i in 1 .. array.size) {
            if (bookArray[i-1] == 0) {
                array[step-1] = i
                bookArray[i-1] = 1
                realDSF(array, bookArray, step + 1)
                bookArray[i-1] = 0
            }
        }
    }
}

fun main() {
    DFS().dsf(3)
}