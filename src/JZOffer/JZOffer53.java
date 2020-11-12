package JZOffer;

public class JZOffer53 {
    public int missingNumber(int[] nums) {
        if (nums.length==1){
            return nums[0]==0?1:0;
        }
        if (nums[0]==1) {
            return 0;
        }
        if (nums[nums.length-1]==nums.length-1){
            return nums.length;
        }
        int low = 0;
        int high = nums.length-1;
        while (low < high-1){
            int mid = low + (high - low)/2;
            if ((high - mid)==(nums[high]-nums[mid])){
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[low]+1;
    }
}
