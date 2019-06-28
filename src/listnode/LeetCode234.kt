package listnode

class LeetCode234 {
    fun isPalindrome(head: ListNode?): Boolean {
        var slowNode = head
        var fastNode = head?.next?.next
        if (slowNode?.next == null) return true
        if (fastNode == null) return slowNode.`val` == slowNode?.next?.`val`
        while (fastNode != null) {
            slowNode = slowNode?.next
            fastNode = fastNode.next?.next
        }
        if (slowNode?.next?.next != null) {
            slowNode = slowNode.next
        }
        println(slowNode)
        var resList:ListNode? = ListNode(-1)
        var target = slowNode
        var newHead = head
        while (slowNode != null) {
            if (resList?.next != null) {
                val node = ListNode(slowNode.`val`)
                node.next = resList.next
                resList.next = node
            } else {
                resList?.next = ListNode(slowNode.`val`)
            }
            slowNode = slowNode.next
        }
        resList = resList?.next!!
        println(resList.next)
        println("target = $target")
        println("newHead = $newHead")
        println("resList = $resList")
        while (newHead != target && resList != null) {
            println("${newHead?.`val`},${resList?.`val`}")
            if (newHead?.`val` == resList?.`val`) {
                newHead = newHead?.next
                resList = resList?.next
                continue
            }
            return false
        }
        return true
    }
}

fun main() {
    println(LeetCode234().isPalindrome(createListNodeByArray(1,2,3,2,1)))
}