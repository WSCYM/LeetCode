package backtrack;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return res;
        StringBuffer path = new StringBuffer();
        path.append(root.val);
        backtracking(path,root);
        return res;
    }

    void backtracking(StringBuffer path,TreeNode curNode){
        if (curNode.left==null && curNode.right==null){
            res.add(path.toString());
            return;
        }
        if (curNode.left!=null){
            path.append("->"+curNode.left.val);
            backtracking(path,curNode.left);
            path.delete(path.length()-String.valueOf(curNode.left.val).length()-2,path.length());
        }
        if (curNode.right!=null){
            path.append("->"+curNode.right.val);
            backtracking(path,curNode.right);
            path.delete(path.length()-String.valueOf(curNode.right.val).length()-2,path.length());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(37);
        TreeNode left = new TreeNode(-34);
        TreeNode right = new TreeNode(-48);
        TreeNode leftright = new TreeNode(-100);
        root.left = left;
        root.right = right;
        left.right = leftright;
        new 二叉树的所有路径().binaryTreePaths(root);
    }
}
