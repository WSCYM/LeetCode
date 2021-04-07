public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    boolean recur (int[] postorder,int l,int r){
        if (l>=r) return true;
        int i = l;
        while (postorder[i]<postorder[r]) i++;
        int m = i;
        while (postorder[i]>postorder[r]) i++;
        boolean retL = recur(postorder, l, m - 1);
        boolean retR = recur(postorder, m, r-1);
        return i==r && retL && retR;
    }
}
