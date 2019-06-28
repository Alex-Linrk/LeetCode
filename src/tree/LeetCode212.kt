package tree

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

/**
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 *单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *示例:
 *
 *输入:
 *words = ["oath","pea","eat","rain"] and board =
 *[
 *['o','a','a','n'],
 *['e','t','a','e'],
 *['i','h','k','r'],
 *['i','f','l','v']
 *]
 *
 *输出: ["eat","oath"]
 *说明:
 *你可以假设所有输入都由小写字母 a-z 组成。
 *
 *提示:
 *
 *你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 *如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
class LeetCode212 {
    val root = Node()
    val inDirct = HashSet<String>()
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        var used = Array(board.size) { BooleanArray(board[0].size) }
        words.forEach {
            insert(it)
            println("find $it = ${find(it)}")
        }
        for (y in board.withIndex()) {
            for (x in y.value.withIndex()) {
                DSF(y.index, x.index, board, StringBuilder(), root, used)
            }
        }
        return inDirct.toList()
    }

    fun DSF(y: Int, x: Int, board: Array<CharArray>, string: StringBuilder, node: Node, used: Array<BooleanArray>) {
        if (y < 0 || y >= board.size || x < 0 || x >= board[y].size) return
        if (used[y][x]) return
        if (node.child[board[y][x].toLowerCase().toInt() - 'a'.toInt()] == null) {
            return
        }
        string.append(board[y][x])
        val next = node.child[board[y][x].toLowerCase().toInt() - 'a'.toInt()]!!
        if (next.word) {
            inDirct.add(string.toString())
        }
        used[y][x] = true
        DSF(y - 1, x, board, string, next, used)
        DSF(y + 1, x, board, string, next, used)
        DSF(y, x - 1, board, string, next, used)
        DSF(y, x + 1, board, string, next, used)
        used[y][x] = false
        string.deleteCharAt(string.lastIndex)
    }

    fun insert(word: String) {
        var currt = root
        for (char in word) {
            val index = char.toLowerCase().toInt() - 'a'.toInt()
            if (currt.child[index] == null) {
                currt.child[index] = Node()
            }
            currt = currt.child[index]!!
        }
        currt.word = true
    }

    fun find(word: String): Boolean {
        var currt = root
        for (char in word) {
            val index = char.toLowerCase().toInt() - 'a'.toInt()
            if (currt.child[index] == null) {
                return false
            }
            currt = currt.child[index]!!
        }
        return currt.word
    }

    class Node {
        var word = false
        val child = arrayOfNulls<Node>(26)
    }

}

fun main() {
    println(
        LeetCode212().findWords(
            arrayOf(
                charArrayOf('o', 'a', 'a', 'n')
                , charArrayOf('e', 't', 'a', 'e')
                , charArrayOf('i', 'h', 'k', 'r')
                , charArrayOf('i', 'f', 'l', 'v')
            ), arrayOf("oath", "pea", "eat", "rain")
        )
    )
}