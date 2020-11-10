package explore.JZOffer;

import classes.TreeNode;

public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
