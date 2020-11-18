package BinarySearch.模板2;

public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]>nums[right]){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        new 寻找旋转排序数组中的最小值().findMin(new int[]{2,1});
    }
}
