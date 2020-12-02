package dp;

public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        //f(i) = max(f(i-2)+nums[i],f(i-1))
        int ll=nums[0],l=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            int tmp = Math.max(ll+nums[i],l);
            ll = l;
            l = tmp;
        }
        return l;
    }
}
