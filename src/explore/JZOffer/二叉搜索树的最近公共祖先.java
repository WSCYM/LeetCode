package explore.JZOffer;

import classes.TreeNode;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp;
        if (p.val>q.val){
            tmp = p;
            p = q;
            q = tmp;
        }
        if (root == null) return null;
        if (p.val<=root.val && q.val>=root.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        if (left!=null) return left;
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (right!=null) return right;
        return null;
    }
}
