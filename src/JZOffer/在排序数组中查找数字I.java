package JZOffer;

public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int i : nums){
            if (i==target){
                count++;
            }
            if (i>target) {
                break;
            }
        }
        return count;
    }
}
