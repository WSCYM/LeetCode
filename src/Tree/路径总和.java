package Tree;

import classes.TreeNode;

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return check(root,sum);
    }
    boolean check(TreeNode root, int sum){
        if (root.left==null && root.right==null){
            return sum-root.val==0;
        }
        boolean rl = false;
        if (root.left!=null){
            rl = check(root.left,sum-root.val);
        }
        boolean rr = false;
        if (root.right!=null){
            rr = check(root.right,sum-root.val);
        }
        return rl||rr;
    }
}
