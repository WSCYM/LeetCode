package array;

//摩尔投票
//public class 多数元素 {
//    public int majorityElement(int[] nums) {
//        int val = nums[0];
//        int sum = 0;
//        for (int i : nums){
//            if (i==val){
//                sum++;
//            } else {
//                if (sum==0){
//                    sum=1;
//                    val = i;
//                } else {
//                    sum--;
//                }
//            }
//        }
//        return val;
//    }
//}

class 多数元素 {

    private int helper(int[] nums, int left, int right) {
        if (left>=right) return nums[left];
        int mid = left + (right-left)/2;
        int numL = helper(nums,left,mid);
        int numR = helper(nums,mid+1,right);
        if (numL==numR) return numL;
        int l = 0;
        int r = 0;
        for (int i = left;i<=right;i++){
            if (nums[i]==numL) l++;
            if (nums[i]==numR) r++;
        }
        return l>r?numL:numR;
    }

    public int majorityElement(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        new 多数元素().majorityElement(new int[]{6,5,5});
    }
}
