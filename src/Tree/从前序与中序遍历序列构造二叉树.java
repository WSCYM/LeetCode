package Tree;

import classes.TreeNode;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 从前序与中序遍历序列构造二叉树
 * @Description TODO
 * @createTime 2020-11-28 14:18:00
 */
public class 从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode helper(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd) {
            return root;
        }
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = helper(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
