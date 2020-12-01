package Tree;

import classes.TreeNode;

import java.util.Arrays;

public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==0){
            return null;
        }
        int index = getMaxIndex(nums);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
        return root;
    }

    int getMaxIndex(int[] nums){
        if (nums.length==0) return -1;
        int index = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>nums[index]){
                index = i;
            }
        }
        return index;
    }
}
