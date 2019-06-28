package listnode;

import java.util.List;

public class IntersectionListNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 0, lenB = 0;
        ListNode newHeadA = headA;
        ListNode newHeadB = headB;
        while (headA != null || headB != null) {
            if (headA != null) {
                lenA++;
                headA = headA.next;
            }
            if (headB != null) {
                headB = headB.next;
                lenB++;
            }
        }
        int disct = lenA - lenB;
        if (disct > 0) {
            while (disct > 0) {
                newHeadA = newHeadA.next;
                disct--;
            }
        } else {
            while (disct < 0) {
                disct++;
                newHeadB = newHeadB.next;
            }
        }
        while (newHeadA != null && newHeadB != null) {
            if (newHeadA == newHeadB) {
                return newHeadA;
            }
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        return null;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
