package array;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i:nums){
            if(i==0) count++;
        }
        int i = 0,tmp=0;
        for(;i<nums.length;i++){
            if(nums[i]!=0){
                nums[tmp] = nums[i];
                tmp++;
            }
        }
        while(tmp<nums.length){
            nums[tmp++]=0;
        }
    }
}
