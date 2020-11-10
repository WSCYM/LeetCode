package JZOffer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode element = queue.remove();
                if (element.left!= null)
                tmpQueue.add(element.left);
                if (element.right!= null)
                tmpQueue.add(element.right);
                list.add(element.val);
            }
            res.add(list);
            queue = tmpQueue;
        }
        return res;
    }
}
