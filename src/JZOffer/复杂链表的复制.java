package JZOffer;

import classes.Node;

import java.util.HashMap;

public class 复杂链表的复制 {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            Node node = new Node(cur.val);
            hashMap.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }
}
