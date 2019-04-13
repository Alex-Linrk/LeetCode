package leecode

class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        generate(res, "", 0, 0, n)
        return res.toList()
    }

    fun generate(res: MutableList<String>, ans: String, count1: Int, count2: Int, n: Int) {
        if (count1 > n || count2 > n) return
        if (count1 == n && count2 == n) res.add(ans)
        if (count1 >= count2) {
            val left = ans
            generate(res, "$ans(", count1 + 1, count2, n)
            generate(res, "$left)", count1, count2 + 1, n)
        }
    }
}

fun main() {
    println(Solution22().generateParenthesis(3))
}