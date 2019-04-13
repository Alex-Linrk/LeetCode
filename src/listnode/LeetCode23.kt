package leecode

import listnode.ListNode
import listnode.createListNodeByArray

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
1->4->5,
1->3->4,
2->6
]
输出: 1->1->2->3->4->4->5->6*/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists == null || lists.isEmpty()) return null
        if (lists.size == 1) return lists[0]
        if (lists.size == 2) return mergeTwoLists(lists[0], lists[1])
        val mid = lists.size / 2
        val list_start = lists.copyOfRange(0, mid)
        val list_end = lists.copyOfRange(mid, lists.size)
        return mergeTwoLists(mergeKLists(list_start), mergeKLists(list_end))
    }

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
    val l1 = createListNodeByArray(1, 4, 5)
    val l2 = createListNodeByArray(1, 3, 4)
    val l3 = createListNodeByArray(2, 6)
    val head = Solution23().mergeKLists(arrayOf(l1, l2, l3))
    println(head)
}