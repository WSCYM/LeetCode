package Tree;

import classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            if (remove==null){
                sb.append("null"+" ");
                continue;
            } else {
                sb.append(remove.val+" ");
            }
            queue.add(remove.left);
            queue.add(remove.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        if (s.length==0 || s[0].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int i = 1;
        while (i<s.length){
            TreeNode remove = queue.remove();
            if (s[i].equals("null")){
                remove.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.valueOf(s[i]));
                remove.left = left;
                queue.add(remove.left);
            }
            i++;
            if (s[i].equals("null")){
                remove.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.valueOf(s[i]));
                remove.right = right;
                queue.add(remove.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(new 二叉树的序列化与反序列化().serialize(n1));
        System.out.println(new 二叉树的序列化与反序列化().deserialize("1 2 3 null null 4 5 null null null null "));
    }
}

