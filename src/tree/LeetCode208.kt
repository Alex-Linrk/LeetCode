package tree

import java.io.File

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 *    示例:
 *
 *   Trie trie = new Trie();
 *
 *   trie.insert("apple");
 *   trie.search("apple");   // 返回 true
 *   trie.search("app");     // 返回 false
 *   trie.startsWith("app"); // 返回 true
 *   trie.insert("app");
 *   trie.search("app");     // 返回 true
 *   说明:
 *
 *   你可以假设所有的输入都是由小写字母 a-z 构成的。
 *   保证所有输入均为非空字符串。
 **/
class Trie() {

    /** Initialize your data structure here. */
    class TrieNode {
        var isTire = false
        var children = arrayOfNulls<TrieNode>(26)
    }

    var root = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var p = root
        for (item in word) {
            val index = item.toLowerCase().toInt()-'a'.toInt()
            if (p.children[index] == null) {
                p.children[index] = TrieNode()
            }
            p = p.children[index]!!
        }
        p.isTire = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        val findWord = findWord(word)
        return findWord!=null && findWord.isTire
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return findWord(prefix)!=null
    }
    fun findWord(word:String):TrieNode?{
        var p = root
        for (itemChar in word) {
            val index = itemChar.toLowerCase().toInt()-'a'.toInt()
            if (p.children[index] == null){
                return null
            }
            p = p.children[index]!!
        }
        return p
    }
}

/**
 * ["Trie","startsWith"]
[[],["a"]]
 */
fun main() {
    val trie = Trie()
    trie.insert("Trie")
    trie.insert("startsWith")
    println(trie.search(""))
    println(trie.search("a"))
}