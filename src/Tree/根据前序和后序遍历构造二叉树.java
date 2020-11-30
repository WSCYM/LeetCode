package Tree;

import classes.TreeNode;

public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,0,pre.length-1,post,0,post.length-1);
    }

    TreeNode helper(int[] pre,int preStart,int preEnd,int[] post,int postStart,int postEnd){
        if (preStart >preEnd){
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart==preEnd){
            return root;
        }
        int index = postStart;
        for(int i=postStart;i<=postEnd;i++){
            if (post[i]==pre[preStart+1]){
                index = i;
            }
        }
        int leftSize = index-postStart;
        root.left = helper(pre,preStart+1,preStart+leftSize+1,post,postStart,index);
        root.right = helper(pre,preStart+leftSize+1+1,preEnd,post,index+1,postEnd-1);
        return root;
    }
}
