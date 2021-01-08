package array;

public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        revArr(nums,nums.length-k,nums.length-1);
        revArr(nums,0,nums.length-1-k);
        revArr(nums,0,nums.length-1);
    }

    void revArr(int[] nums,int start,int end){
        int tmp;
        while (start<end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
