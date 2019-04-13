package leecode

import listnode.ListNode
import listnode.createListNodeByArray

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        var head: ListNode? = null
        if (l1.`val` <= l2.`val`) {
            head = l1
            head.next = mergeTwoLists(l1.next, l2)
        } else {
            head = l2
            head.next = mergeTwoLists(l1, l2.next)
        }
        return head
    }
}

fun main() {
    val l1 = createListNodeByArray(1, 2, 3, 4, 5)
    println(l1)
    val l2 = createListNodeByArray(6, 7, 8, 9)
    println(l2)
    var head = Solution21().mergeTwoLists(l1, l2)
    println(head)

}
