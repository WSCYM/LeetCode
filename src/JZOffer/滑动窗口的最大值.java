package JZOffer;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[0];
        }
        int left=0,right=k-1;
        int t=0;
        int[] res = new int[nums.length-k+1];
        while (right<nums.length){
            Integer max = Integer.MIN_VALUE;
            for (int i = left;i<=right;i++) {
                if (nums[i] > max){
                    max = nums[i];
                }
            }
            res[t++] = max;
            left++;
            right++;
        }
        return res;
    }
}
