package divideAndConquer;

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        return divideConquer(nums,0,nums.length-1);
    }

    public int divideConquer(int[] nums,int low,int high) {
        if (low>=high){
            return nums[low];
        }

        int mid = low+(high-low)/2;
        int left = divideConquer(nums,low,mid-1);
        int right = divideConquer(nums,mid+1,high);

        int maxMid = nums[mid];
        int curMId = nums[mid];
        for (int i = mid-1;i>=low;i--){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        curMId = maxMid;
        for (int i = mid+1;i<=high;i++){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        return Math.max(Math.max(left,right),maxMid);
    }
}
