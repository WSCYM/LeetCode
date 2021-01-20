package divideAndConquer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++){
            arr[i] = i+1;
        }
        return helper(arr,0,arr.length-1);
    }

    private List<TreeNode> helper(int[] nums,int low,int high){
        List<TreeNode> res = new ArrayList<>();
        if (low>high){
            res.add(null);
            return res;
        }
        for (int i=low;i<=high;i++){
            List<TreeNode> left = helper(nums, low, i - 1);
            List<TreeNode> right = helper(nums,i+1,high);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode node = new TreeNode(nums[i]);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 不同的二叉搜索树II().generateTrees(3));
    }
}
