package array

/**
 * 只出现一次的数：
 * 要求不开辟新的空间，最后是找到网上解法：
 * 通过所有数按位与或，因为相同的数按未与或运算后结果为0，所以最后只会剩下只出现一次的那个数
 */
class SolutionM1 {
    fun singleNumber(nums: IntArray): Int {
        var count = 0
        nums.forEach { it->count = count xor it }
        return count
    }
}

fun main(args: Array<String>) {
    println(SolutionM1().singleNumber(intArrayOf(1,2,2,1,4)))
}