package Tree;

import classes.TreeNode;

public class 祖父节点值为偶数的节点和 {
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        modifyRes(root);
        return res;
    }
    void modifyRes(TreeNode root){
        if(root==null) return;
        if (root.left==null && root.right==null){
            return;
        }
        if (root.val%2==0){
            if (root.left!=null){
                res = root.left.left==null?res:res+root.left.left.val;
                res = root.left.right==null?res:res+root.left.right.val;
            }
            if (root.right!=null){
                res = root.right.left==null?res:res+root.right.left.val;
                res = root.right.right==null?res:res+root.right.right.val;
            }
        }
        modifyRes(root.left);
        modifyRes(root.right);
    }
}
