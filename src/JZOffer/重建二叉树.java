package JZOffer;

import classes.TreeNode;

public class 重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder,int preStart,int preEnd
            ,int[] inorder,int inStart,int inEnd){
        if (preStart>preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd) return root;
        int index = inStart;
        while (inorder[index]!=rootVal){
            index++;
        }
        int leftSize = index-inStart;
        TreeNode left = helper(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        TreeNode right = helper(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}
