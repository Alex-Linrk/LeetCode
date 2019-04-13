package leecode

import listnode.ListNode
import listnode.createListNodeByArray
import java.lang.StringBuilder

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 1
        var end = head
        while (end?.next != null) {
            end = end.next
            size++
        }
        if (n >= size) {
            return head?.next
        } else {
            var pos = head
            val local = size - n
            for (i in 0 until local - 1) {
                pos = pos?.next
            }
            pos?.next = pos?.next?.next
        }
        return head
    }
}


fun main() {
    var head = createListNodeByArray(1, 2, 3)
    print(head)
    head = Solution().removeNthFromEnd(head, 3)
    print(head.toString())
}