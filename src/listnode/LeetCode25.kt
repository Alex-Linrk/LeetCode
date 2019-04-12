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
class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var cur = 1
        var newHead: ListNode? = head
        while (cur < k && newHead != null) {
            newHead = newHead.next
            cur++
        }
        if (newHead != null) {
            val theNext = newHead.next
            newHead.next = null
            val theNewHead = reverseGroup(head)
            head?.next = reverseKGroup(theNext, k)
            return theNewHead
        }
        return head
    }

    fun reverseGroup(head: ListNode?): ListNode? {
        val emptyHead = ListNode(0)
        var newHead: ListNode? = head
        while (newHead != null) {
            val theNext: ListNode? = emptyHead.next
            emptyHead.next = newHead
            newHead = newHead?.next
            emptyHead?.next?.next = theNext
        }
        return emptyHead.next
    }

}

fun main(args: Array<String>) {
    val head = createListNodeByArray(1, 2)
    println(Solution25().reverseKGroup(head, 3))
}
