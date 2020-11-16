package array;

public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int p = 0,v = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=v){
                nums[p] = nums[i];
                v=nums[p];
                p++;
            }
        }
        return p;
    }
}
