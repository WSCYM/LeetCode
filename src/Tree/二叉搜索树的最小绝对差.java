package Tree;

import classes.TreeNode;

public class 二叉搜索树的最小绝对差 {
    int res=Integer.MAX_VALUE;
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        if (pre!=-1) {
            res=Math.min(Math.abs(pre-root.val),res);
            pre = root.val;
        } else {
            pre = root.val;
        }
        dfs(root.right);
    }
}
