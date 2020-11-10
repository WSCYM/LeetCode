package explore.JZOffer;

import java.util.ArrayList;

public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int left=1,right=1;
        ArrayList<int[]> res = new ArrayList<>();
        while (right<target){
            right++;
            int sum = getSum(left,right);
            while (sum>target) {
                sum-=left;
                left++;
            }
            if (sum==target){
                int[] arr = new int[right-left+1];
                for (int i = 0,k=left;k<=right;i++,k++){
                    arr[i] = k;
                }
                if (arr.length>1)
                    res.add(arr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    int getSum(int left,int right){
        int sum = 0;
        while (left<=right){
            sum+=left;
            left++;
        }
        return sum;
    }

    public static void main(String[] args) {
        new 和为s的连续正数序列().findContinuousSequence(9);
    }
}
