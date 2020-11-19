package BinarySearch;

public class 寻找旋转排序数组中的最小值2 {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0){
            return -1;
        }
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]>nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
