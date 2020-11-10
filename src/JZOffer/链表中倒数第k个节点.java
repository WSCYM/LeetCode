package JZOffer;

import classes.ListNode;

import java.util.ArrayList;

public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();

        while (head != null){
            nodes.add(head);
            head = head.next;
        }

        return nodes.get(nodes.size() - k);
    }
}
