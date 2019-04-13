package array

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty() || s.length == 1) return true
        val list = mutableListOf<Char>()
        s.forEach {
            val lower = it.toLowerCase()
            if (lower in 'a'..'z' || lower in '0'..'9')
                list.add(lower)

        }
        println(list)
        var start = 0
        var end = list.lastIndex
        if (start >= end) return true
        while (start <= end) {
            if (list[start++] == list[end--]) {
                continue
            }
            return false
        }
        return true
    }
}

fun main() {
    println(Solution125().isPalindrome("0P"))
}