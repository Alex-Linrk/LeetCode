package array

import java.util.*

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
"cats and dog",
"cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
"pine apple pen apple",
"pineapple pen apple",
"pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
 解法：
 同样是动态规划，但是这次使用一个记忆数组，记录当这个结果符合时候的结果。
 map负责记录当s字符串被分割后是否符合。如果不符合则返回结果为空，如果符合则记录结果。
 然后从前往后记录分隔符，从0开始。
 如："pineapplepenapple"
 依次分为："","pineapplepenapple"
          "p","ineapplepenapple"
            ……
          "pineapplepen","apple"
 此时，"apple"字符符合，将"pineapplepen"字串递归以上过程，获得结果
 * **/
class Solution140 {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        return DSF(s, wordDict, mutableMapOf())
    }

    fun DSF(s: String, wordDict: List<String>,map:MutableMap<String,List<String>>): List<String> {
        if (map.containsKey(s))
            return map[s]!!
        var result = mutableListOf<String>()
        for (x in 0 until s.length) {
            if (wordDict.contains(s.substring(x))) {
                val list = DSF(s.substring(0, x), wordDict,map)
                if (list.isNotEmpty()) {
                    list.forEach {
                        result.add(it.plus(" ").plus(s.substring(x)))
                    }
                } else {
                    if (x == 0)
                        result.add(s)
                }
            }
        }
        map[s] = result
        return result
    }
}

fun main() {
    println(
        Solution140().wordBreak(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    , listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
        )
    )
}