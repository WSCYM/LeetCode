package JZOffer;

import classes.TreeNode;

public class 平衡二叉树 {
//    Boolean flag = true;
//    public boolean isBalanced(TreeNode root) {
//        dfs(root);
//        return flag;
//    }
//    void dfs(TreeNode root){
//        if (root==null) return;
//        isBalanced(root.left);
//        isBalanced(root.right);
//        if (Math.abs(getDepth(root.left)-getDepth(root.right))>1){
//            flag = false;
//        }
//    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left)){
            return false;
        }
        if (!isBalanced(root.right)){
            return false;
        }
        int leftDep = getDepth(root.left);
        int rightDep = getDepth(root.right);
        if (Math.abs(leftDep-rightDep)>1){
            return false;
        }
        return true;
    }

    int getDepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
