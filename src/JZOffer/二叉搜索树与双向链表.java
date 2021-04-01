package JZOffer;

import classes.Node;

import java.util.ArrayList;

//public class 二叉搜索树与双向链表 {
//    ArrayList<Node> as = new ArrayList<>();
//    public Node treeToDoublyList(Node root) {
//        if (root==null) return null;
//        r(root);
//        for (int i = 0;i<as.size();i++){
//            //后继
//            if (i!=as.size()-1){
//                as.get(i).right = as.get(i+1);
//            }
//            //前驱
//            if (i!=0){
//                as.get(i).left = as.get(i-1);
//            }
//        }
//        //最后一个点的后继
//        as.get(as.size()-1).right=as.get(0);
//        //第一个点的前驱
//        as.get(0).left=as.get(as.size()-1);
//        return as.get(0);
//    }
//
//    void r(Node root){
//        if (root==null){
//            return;
//        }
//        r(root.left);
//        as.add(root);
//        r(root.right);
//    }
//}


public class 二叉搜索树与双向链表 {
    Node head=null,pre=null;
    public Node treeToDoublyList(Node root) {
        if (root==null) return null;
        r(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void r(Node cur){
        if (cur==null){
            return;
        }
        r(cur.left);
        if (pre!= null){
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        r(cur.right);
    }
}
