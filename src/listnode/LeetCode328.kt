package listnode

class LeetCode328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        var o = head

        // p 为偶链表头结点
        var p = head.next

        // e 为偶链表尾节点
        var e = p
        while (o?.next != null && e?.next != null) {
            o.next = e.next
            o = o.next
            e.next = o?.next
            e = e.next
        }
        o?.next = p
        return head
    }

}

fun main() {
    println(LeetCode328().oddEvenList(createListNodeByArray(1, 2, 3, 4, 5)))
}