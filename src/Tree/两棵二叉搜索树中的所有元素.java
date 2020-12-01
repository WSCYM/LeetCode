package Tree;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 两棵二叉搜索树中的所有元素 {
    List<Integer> as1 = new ArrayList<>();
    List<Integer> as2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1,as1);
        dfs(root2,as2);
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0;
        while (i<as1.size() && j<as2.size()){
            if (as1.get(i)==as2.get(j)){
                res.add(as1.get(i));
                res.add(as2.get(j));
                i++;
                j++;
            } else if (as1.get(i)<as2.get(j)){
                res.add(as1.get(i));
                i++;
            } else {
                res.add(as2.get(j));
                j++;
            }
        }
        if (j!=as2.size()){
            while (j<as2.size()){
                res.add(as2.get(j));
                j++;
            }
        }
        if (i!=as1.size()){
            while (i<as1.size()){
                res.add(as1.get(i));
                i++;
            }
        }
        return res;
    }
    void dfs(TreeNode root,List<Integer> as){
        if (root==null){
            return;
        }
        dfs(root.left,as);
        as.add(root.val);
        dfs(root.right,as);
    }
}
