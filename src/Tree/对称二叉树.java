package Tree;

import classes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    boolean check(TreeNode p,TreeNode q){
        if (p==null && q == null){
            return true;
        } else if (p==null || q==null){
            return false;
        } else {
            if (p.val==q.val && check(p.left,q.right) && check(p.right,q.left)){
                return true;
            } else {
                return false;
            }
        }
    }


}
