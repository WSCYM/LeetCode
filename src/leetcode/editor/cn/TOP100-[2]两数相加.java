package leetcode.editor.cn;
import classes.ListNode;
import classes.Node;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6209 👎 0


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
class Solution2 {
//    //迭代
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int add = 0;
//        ListNode head = new ListNode(0);
//        ListNode p = head;
//        while (l1!=null && l2!=null){
//            int val = l1.val+l2.val+add;
//            p.next = new ListNode(val%10);
//            p=p.next;
//            if (val>=10){
//                add = 1;
//            } else {
//                add = 0;
//            }
//            l1=l1.next;
//            l2=l2.next;
//        }
//        ListNode tail = l1==null?l2:l1;
//        while (tail!=null){
//            int val = tail.val+add;
//            p.next = new ListNode(val%10);
//            p=p.next;
//            if (val>=10){
//                add = 1;
//            } else {
//                add = 0;
//            }
//            tail=tail.next;
//        }
//        if (add!=0){
//            p.next = new ListNode(1);
//        }
//        return head.next;
//    }
    //递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return r(l1,l2,0);
    }

    private ListNode r(ListNode l1,ListNode l2,int add){
        if (l1==null && l2==null && add==0) return null;
        int val = add+(l1!=null?l1.val:0)+(l2!=null?l2.val:0);
        ListNode curNode = new ListNode(val%10);
        curNode.next = r(l1==null?null:l1.next,l2==null?null:l2.next,val>=10?1:0);
        return curNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
