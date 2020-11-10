package JZOffer;

import classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的深度 {

//    public int maxDepth(TreeNode root) {
//
//        if(root == null) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//
//    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<TreeNode> tmp;
        while (!queue.isEmpty()){
            tmp = new LinkedList<>();
            for (TreeNode treeNode : queue){
                if (treeNode.left!=null){
                    tmp.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    tmp.offer(treeNode.right);
                }
            }
            dep ++;
            queue = tmp;
        }
        return dep;
    }

}
