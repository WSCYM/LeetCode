package JZOffer;

import classes.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        int[] res = new int[2001];
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            res[i++] = remove.val;
            if (remove.left!=null){
                queue.add(remove.left);
            }
            if (remove.right!=null){
                queue.add(remove.right);
            }
        }
        return Arrays.copyOf(res,i);
    }
}
