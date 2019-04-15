package array

import kotlin.math.max

/**
 * 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
["aa","b"],
["a","a","b"]
]
 */
class Solution131 {
    fun partition(s: String): List<List<String>> {
        var res = spliteMoreOne(s)
        if (s.length > 1)
            res.add(listOf(s))
        var newResult = mutableListOf<List<String>>()
        loop@ for (list in res) {
            for (str in list) {
                if (isSummery(str).not()) continue@loop
            }
            newResult.add(list)
        }
        return newResult
    }

    fun spliteAllByOne(s: String): List<List<String>> {
        if (s.isEmpty()) return emptyList()
        if (s.length == 1) return mutableListOf(listOf(s))
        val result = mutableListOf<List<String>>()
        var start = 1
        while (start < s.length) {
            val begin = s.subSequence(0, start).toString()
            val end = s.substring(start++, s.length)
            result.add(listOf(begin, end))
        }
        return result
    }


    fun isSummery(str: String): Boolean {
        if (str.isEmpty() || str.length == 1) return true
        var start = 0
        var end = str.lastIndex
        while (start <= end) {
            if (str[start++] != str[end--]) return false
        }
        return true
    }

    fun spliteMoreOne(s: String): MutableList<List<String>> {
        var maxSplit = s.length - 1
        var temp = spliteAllByOne(s)
        var result = mutableListOf<List<String>>()
        result.addAll(temp)
        while (maxSplit > 1) {
            val newTemp = mutableListOf<List<String>>()
            temp.forEach { it ->
                if (it[it.lastIndex].length > 1) {
                    val res = spliteAllByOne(it[it.lastIndex])
                    res.forEach { newResult ->
                        val newList = mutableListOf<String>()
                        newList.addAll(it.subList(0, it.lastIndex))
                        newList.addAll(newResult)
                        newTemp.add(newList)
                    }

                }
            }
            result.addAll(newTemp)
            temp = newTemp
            maxSplit--
        }
        return result
    }
}

fun main() {
    println(Solution131().partition("amanaplanacanalpanama"))
}