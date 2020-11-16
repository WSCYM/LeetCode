package array;

public class 删除排序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int slow=0,count=1;
        for (int i = 0;i<nums.length;i++){
            if (slow!=i){
                if (nums[slow]!=nums[i]){
                    nums[++slow] = nums[i];
                    count = 1;
                } else if (nums[slow]==nums[i]){
                    if (count<2){
                        nums[++slow] = nums[i];
                        count ++;
                    }
                }
            }
        }
        return slow+1;
    }
}
