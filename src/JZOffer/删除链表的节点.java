package JZOffer;

import classes.ListNode;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 删除链表的节点
 * @Description TODO
 * @createTime 2020-11-07 22:27:00
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val){
            return head.next;
        }
        ListNode i = head;
        while (i.next!=null){
            if (i.next.val == val){
                i.next = i.next.next;
                break;
            }
            i=i.next;
        }
        return head;
    }
}
