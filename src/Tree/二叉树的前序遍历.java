package Tree;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        order(root);
//        return list;
//    }
//    public void order(TreeNode root){
//        if (root==null){
//            return;
//        }
//        list.add(root.val);
//        order(root.left);
//        order(root.right);
//    }

    //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                res.add(p.val);
                stack.push(p);
                p=p.left;
            }
            p = stack.pop();
            p=p.right;
        }
        return res;
    }
}
