package greedy;

public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        if (nums.length<=2) return true;
        for (int i = 1;i<nums.length;i++){
            if (nums[i-1] <= nums[i]) {
                continue;
            }
            cnt++;
                if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
        }
        return cnt<=1;
    }
}
