package divideAndConquer;

public class 连续数列 {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums,int lo,int hi){
        if (lo>=hi){
            return nums[lo];
        }
        int mid = lo + (hi-lo)/2;
        int left = helper(nums,lo,mid-1);
        int right = helper(nums,mid+1,hi);
        int maxSumMidL = 0;
        int maxSumMidR = 0;
        int sumMidL = 0;
        int sumMidR = 0;
        for (int i = mid-1;i>=0;i--){
            sumMidL+=nums[i];
            if (sumMidL>maxSumMidL){
                maxSumMidL = sumMidL;
            }
        }
        for (int i = mid+1;i<=hi;i++){
            sumMidR+=nums[i];
            if (sumMidR>maxSumMidR){
                maxSumMidR = sumMidR;
            }
        }
        int maxSumMid = maxSumMidL+maxSumMidR+nums[mid];
        return Math.max(Math.max(left,right),maxSumMid);
    }

    public static void main(String[] args) {
        new 连续数列().maxSubArray(new int[]{8,-19,5,-4,20});
    }
}
