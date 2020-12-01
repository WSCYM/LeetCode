package Tree;

import classes.TreeNode;

import java.util.HashMap;

public class 层数最深叶子节点的和 {
    int maxLev=1;
    int res = 0;
    public int deepestLeavesSum(TreeNode root) {
        modifyRes(root,1);
        return res;
    }
    public void modifyRes(TreeNode root,int depth){

        if (depth==maxLev){
            res += root.val;
        }
        if (depth>maxLev){
            res = root.val;
            maxLev = depth;
        }

        if (root.left!=null) modifyRes(root.left,depth+1);
        if (root.right!=null) modifyRes(root.right,depth+1);
    }
}
