package Tree;

import classes.TreeNode;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 从中序与后序遍历序列构造二叉树
 * @Description TODO
 * @createTime 2020-11-28 16:07:00
 */
public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    TreeNode helper(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        if (inStart>inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        if (inStart==inEnd) return root;
        int rootIndex = 0;
        for (int i=inStart;i<=inEnd;i++){
            if (rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex-inStart;
        root.left = helper(inorder,inStart,rootIndex-1,postorder,postStart,postStart+leftSize-1);
        root.right = helper(inorder,rootIndex+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
