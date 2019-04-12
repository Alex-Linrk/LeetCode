package listnode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        var newHead: ListNode? = head?.next ?: return head
        head?.next = head?.next?.next
        newHead?.next = head
        if (head?.next != null) {
            newHead?.next?.next = swapPairs(head.next)
        }
        return newHead
    }
}

fun main(args: Array<String>) {
    val head = createListNodeByArray(1)
    println(head)
    println(Solution24().swapPairs(head))
}