package sort;

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        int idx;
        for (int i = 0;i<k;i++){
            idx = i;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]>nums[idx]){
                    idx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = tmp;
        }
        return nums[k-1];
    }
}
