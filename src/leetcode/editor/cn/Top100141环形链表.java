package leetcode.editor.cn;

import classes.ListNode;

public class Top100141环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast==null){
                return false;
            } else {
                fast=fast.next;
            }
            if (fast==null){
                return false;
            } else {
                fast=fast.next;
            }
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
    }
}
