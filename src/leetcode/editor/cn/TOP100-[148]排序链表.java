package leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1199 👎 0

import classes.ListNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {

    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmpRHead = slow.next;
        slow.next=null;
        ListNode l = sortList(head);
        ListNode r = sortList(tmpRHead);
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        while (l!=null && r!=null){
            if (l.val<=r.val){
                p.next = l;
                p=p.next;
                l=l.next;
            } else {
                p.next = r;
                p=p.next;
                r=r.next;
            }
            p.next = l==null?r:l;
        }
        return pre.next;
    }

//    public static void main(String[] args) {
//        ListNode listNode1 =new ListNode(4);
//        ListNode listNode2 =new ListNode(2);
//        ListNode listNode3 =new ListNode(1);
//        ListNode listNode4 =new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        new Solution().sortList(listNode1);
//    }

//    public ListNode sortList(ListNode head) {
//        ListNode tmpHead = new ListNode(-1);
//        ListNode node = head;
//        ListNode tmpNode = null;
//        ListNode p = null;
//        while (node!=null){
//            p = tmpHead;
//            while (p.next!=null && p.next.val<node.val){
//                p=p.next;
//            }
//            tmpNode = node.next;
//            node.next = p.next;
//            p.next = node;
//            node = tmpNode;
//        }
//        return tmpHead.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
