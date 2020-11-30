package Tree;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        order(root);
//        return list;
//    }
//    public void order(TreeNode root){
//        if (root==null){
//            return;
//        }
//        order(root.left);
//        order(root.right);
//        list.add(root.val);
//    }
    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                res.add(p.val);
                stack.push(p);
                p=p.right;
            }
            p = stack.pop();
            p=p.left;
        }
        Collections.reverse(res);
        return res;
    }
}
