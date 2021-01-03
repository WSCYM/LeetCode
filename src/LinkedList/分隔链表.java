package LinkedList;

import classes.ListNode;

public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode pl = l;
        ListNode pr = r;
        while (head!=null){
            ListNode node = new ListNode(head.val);
            if (head.val<x){
                pl.next = node;
                pl = pl.next;
            }else {
                pr.next = node;
                pr = pr.next;
            }
            head = head.next;
        }
        pl.next = r.next;
        return l.next;
    }
}
