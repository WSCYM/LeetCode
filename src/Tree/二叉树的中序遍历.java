package Tree;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        inOrder(root);
//        return res;
//    }
//    void inOrder(TreeNode root){
//        if (root==null) return;
//        inOrder(root.left);
//        res.add(root.val);
//        inOrder(root.right);
//    }
    //迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p=p.right;
        }
        return res;
    }
}
