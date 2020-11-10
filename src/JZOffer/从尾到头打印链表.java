package JZOffer;

import classes.ListNode;

import java.util.ArrayList;

public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList();
        while (head!=null){
            arrayList.add(head.val);
            head = head.next;
        }
        int[] res = new int[arrayList.size()];
        for (int i = arrayList.size()-1;i>=0;i--){
            res[arrayList.size()-i-1] = arrayList.get(i);
        }
        return res;
    }
}
