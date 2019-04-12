package listnode

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    /**
     * 打印链表
     */
    override fun toString(): String {
        if (next == null)
            return "[$`val`]"
        var result = "[$`val`"
        var hasNext: ListNode? = next
        while (hasNext != null) {
            result = "$result,${hasNext.`val`}"
            hasNext = hasNext.next
        }
        return "$result]"
    }
}

/**
 * 递归创建链表
 */
fun createListNodeByArray(vararg items: Int): ListNode? {
    if (items.isEmpty()) return null
    val head = ListNode(items[0])
    if (items.isNotEmpty())
        head.next = createListNodeByArray(*items.copyOfRange(1, items.size))
    return head

}

fun main(args: Array<String>) {
    println(createListNodeByArray(1, 2))
}