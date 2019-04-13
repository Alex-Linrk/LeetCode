package leecode

class Solution20 {
    fun isValid(s: String): Boolean {
        val left = mutableListOf<Char>()
        s.forEach {
            when (it) {
                '(', '[', '{' -> left.add(it)
                ')' -> {
                    if (left.size == 0 || left[left.lastIndex] != '(') {
                        return false
                    } else {
                        left.removeAt(left.lastIndex)
                    }
                }
                ']' -> {
                    if (left.size == 0 || left[left.lastIndex] != '[') {
                        return false
                    } else {
                        left.removeAt(left.lastIndex)
                    }
                }
                '}' -> {
                    if (left.size == 0 || left[left.lastIndex] != '{') {
                        return false
                    } else {
                        left.removeAt(left.lastIndex)
                    }
                }
            }
        }
        return left.size == 0
    }
}

fun main() {
    println(Solution20().isValid(")))))"))
}