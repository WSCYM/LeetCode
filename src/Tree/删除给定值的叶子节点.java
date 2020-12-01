package Tree;

import classes.TreeNode;

public class 删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root,target);
        if (root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
    void dfs(TreeNode root,int target){
        if (root==null) return;
        if (root.left==null && root.right == null){
            return;
        }
        dfs(root.left,target);
        dfs(root.right,target);
        if (root.left!=null && root.left.val==target &&root.left.left==null&& root.left.right==null){
            root.left = null;
        }
        if (root.right!=null && root.right.val==target &&root.right.left==null&& root.right.right==null){
            root.right = null;
        }
    }
}
