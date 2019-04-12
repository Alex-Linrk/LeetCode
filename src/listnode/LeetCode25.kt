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
    /**
     * 反转K个链表数
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        /**截取前N个节点**/
        var cur = 1
        var newHead: ListNode? = head
        while (cur < k && newHead != null) {
            newHead = newHead.next
            cur++
        }
        /**判断是否有后续节点**/
        if (newHead != null) {
            val theNext = newHead.next
            newHead.next = null
            /**反转前链表**/
            val theNewHead = reverseGroup(head)
            /**
             * 拼接后续链表
             */
            head?.next = reverseKGroup(theNext, k)
            return theNewHead
        }
        return head
    }

    /**
     * 反转链表
     */
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
