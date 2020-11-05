package explore.JZOffer;

import classes.ListNode;

public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);
        ListNode tmp = l0;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if (l1!=null){
            tmp.next = l1;
        }
        if (l2!=null){
            tmp.next = l2;
        }
        return l0.next;
    }
}
