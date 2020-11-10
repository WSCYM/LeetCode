package explore.JZOffer;

import classes.ListNode;

import java.util.HashSet;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 两个链表的第一个公共节点
 * @Description TODO
 * @createTime 2020-11-07 19:50:00
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (hashSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
