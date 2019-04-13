package leecode

import kotlin.math.min

class Solution261 {
    fun nthUglyNumber(n: Int): Int {
        val list = IntArray(n)
        var int_2 = 0
        var int_3 = 0
        var int_5 = 0
        list[0] = 1
        for (i in 1 until n) {
            val next = min(min(list[int_2] * 2, list[int_3] * 3), list[int_5] * 5)
            if (next == list[int_2] * 2)
                int_2 += 1
            if (next == list[int_3] * 3)
                int_3 += 1
            if (next == list[int_5] * 5)
                int_5 += 1
            list[i] = next
        }
        return list[list.lastIndex]
    }

    fun min(a: Int, b: Int): Int {
        return if (a > b) {
            b
        } else {
            a
        }
    }

}

fun main() {
    println(Solution261().nthUglyNumber(2))
}