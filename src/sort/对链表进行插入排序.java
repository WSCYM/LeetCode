package sort;

import classes.ListNode;

public class 对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        while (head!=null){
            ListNode p = res;
            while (p.next!=null && p.next.val<head.val){
                p=p.next;
            }
            ListNode node = new ListNode(head.val);
            node.next = p.next;
            p.next = node;
            head = head.next;
        }
        return res.next;
    }
}
