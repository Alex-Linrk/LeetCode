package listnode

class LeetCode148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        return sort(head)
    }

    fun sort(head: ListNode): ListNode {
        if (head.next == null) return head
        if (head.next?.next == null) {
            val next = head.next
            head.next = null
            return merage(next, head)
        }
        var left = head
        var right = left.next
        right = right?.next
        while (right != null) {
            left = left.next!!
            right = right.next?.next
        }
        println(left)
        var newHead = head
        while (newHead.next != left) {
            newHead = newHead.next!!
        }
        newHead.next = null
        return merage(sort(head), sort(left))
    }

    fun merage(left: ListNode?, right: ListNode?): ListNode {
        var head = ListNode(-1)
        var cpLeft = left
        var cpRight = right
        var node: ListNode? = head
        while (cpLeft != null && cpRight != null) {
            println(cpLeft)
            println(cpRight)
            if (cpLeft.`val` < cpRight.`val`) {
                node!!.next = cpLeft
                cpLeft = cpLeft.next
            } else {
                node!!.next = cpRight
                cpRight = cpRight.next
            }
            node = node.next
        }
        if (cpLeft != null) {
            node!!.next = cpLeft
        } else if (cpRight != null) {
            node!!.next = cpRight
        }
        return head.next!!
    }
}

fun main() {
    println(LeetCode148().sortList(createListNodeByArray(4, 2, 1, 3, 5)))
//    println(LeetCode148().merage(createListNodeByArray(1,3)!!, createListNodeByArray(2, 4)))
}