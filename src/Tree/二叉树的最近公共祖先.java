package Tree;

import classes.TreeNode;

public class 二叉树的最近公共祖先 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isAnc(root,p.val,q.val);
        return res;
    }

    Boolean isAnc(TreeNode root,int p,int q) {
        if (root == null) {
            return false;
        }
        boolean l = isAnc(root.left,p,q);
        boolean r = isAnc(root.right,p,q);
        if ((l&&r) || (l&&(root.val==p||root.val==q)) || (r&&(root.val==p||root.val==q))){
            res = root;
            return true;
        } else if (l||r){
            return true;
        } else if (root.val==p||root.val==q){
            return true;
        } else {
            return false;
        }
    }
}
