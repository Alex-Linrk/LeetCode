package listnode;

public class CycleListNode {
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        if (node != null && node.next != null) {
            node = node.next.next;
        } else {
            node = null;
        }
        while (node != null && head != node) {
            head = head.next;
            if (node.next != null) {
                node = node.next.next;
            } else {
                node = null;
            }
        }
        return node != null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode node = head.next;
        node.next = new ListNode(0);
        node = node.next;
        node.next = new ListNode(-4);
        node = node.next;
        node.next = head.next;
        System.out.println(new CycleListNode().hasCycle(head));
        System.out.println(new CycleListNode().hasCycle(new ListNode(1)));
    }
}
