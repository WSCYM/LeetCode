package twoPointer;

import classes.ListNode;

public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null || fast.next.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) break;
            //f = 2nb s=nb
        }
        fast = head;
        while (true){
            if (fast==slow){
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
