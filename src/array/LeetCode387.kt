package array

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 *例:

 * = "leetcode"
 *回 0.

 * = "loveleetcode",
 *回 2.


 *意事项：您可以假定该字符串只包含小写字母。
 * **/
class LeetCode387 {
    fun firstUniqChar(s: String): Int {
        val array = IntArray(26)
        for (c in s) {
            val index = c.toLowerCase().toInt() - 'a'.toInt()
            array[index]++
        }
        var position = -1
        for (charValue in array.withIndex()) {
            if (charValue.value == 1) {
                for (item in s.withIndex()) {
                    if (item.value.toInt() == charValue.index + 'a'.toInt()) {
                        if (position == -1 || item.index < position)
                            position = item.index
                    }
                }
            }
        }
        return position
    }
}