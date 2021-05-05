package JZOffer;

import classes.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {
}


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return  "[]";
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            if (remove == null) {
                sb.append("null");
            } else {
                sb.append(remove.val);
                queue.add(remove.left);
                queue.add(remove.right);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()<=2) return null;
        StringBuffer sb = new StringBuffer(data);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        String string = sb.toString();
        String[] split = string.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i<split.length){
            TreeNode remove = queue.remove();
            if (!split[i].equals("null")){
                TreeNode l = new TreeNode(Integer.valueOf(split[i]));
                remove.left=l;
                queue.add(l);
            }
            i++;
            if (!split[i].equals("null")){
                TreeNode r = new TreeNode(Integer.valueOf(split[i]));
                remove.right=r;
                queue.add(r);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode rl = new TreeNode(4);
        TreeNode rr = new TreeNode(5);
        root.left = l ;
        root.right = r;
        r.left = rl;
        r.right = rr;
        System.out.println(new Codec().serialize(root));
        new Codec().deserialize("[1,2,3,null,null,4,5,null,null,null,null]");
    }
}