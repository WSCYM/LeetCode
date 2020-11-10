package explore.JZOffer;

import classes.TreeNode;

import java.util.*;

public class 从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmp;
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> subRes = new ArrayList<>();
            tmp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode remove = queue.remove();
                subRes.add(remove.val);
                if (remove.left!=null){
                    tmp.add(remove.left);
                }
                if (remove.right!= null){
                    tmp.add(remove.right);
                }

            }
            queue = tmp;
            res.add(subRes);
        }
        Boolean reverse = false;
        for (List<Integer> it : res){
            if (reverse){
                Collections.reverse(it);
            }
            reverse = !reverse;
        }
        return res;
    }
}
