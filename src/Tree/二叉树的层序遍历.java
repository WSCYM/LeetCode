package Tree;

import classes.TreeNode;

import java.util.*;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> as = new ArrayList<>();
            Queue tmp = new LinkedList();
            for (TreeNode treeNode : queue){
                as.add(treeNode.val);
                if (treeNode.left!=null){
                    tmp.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    tmp.add(treeNode.right);
                }
            }
            res.add(as);
            queue = tmp;
        }
        return res;
    }
}
