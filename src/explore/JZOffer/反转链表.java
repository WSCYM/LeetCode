package explore.JZOffer;

import classes.ListNode;

import java.util.Stack;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode top = stack.pop();
        ListNode tmp = top;
        while (!stack.isEmpty()){
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = null;
        return top;
    }
}
