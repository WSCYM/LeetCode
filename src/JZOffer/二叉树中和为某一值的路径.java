package JZOffer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> ret = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root==null) return ret;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        sum+=root.val;
        dfs(target,root,path);
        return ret;
    }

    private void dfs(int target,TreeNode root,List<Integer> path){
        if (root.left==null && root.right==null){
            if (sum==target){
                ret.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left!=null){
            sum+=root.left.val;
            path.add(root.left.val);
            dfs(target,root.left,path);
            path.remove(path.size()-1);
            sum-=root.left.val;
        }
        if (root.right!=null){
            sum+=root.right.val;
            path.add(root.right.val);
            dfs(target,root.right,path);
            path.remove(path.size()-1);
            sum-=root.right.val;
        }
    }
}
