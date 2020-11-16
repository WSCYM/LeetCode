package array;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i<n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new 移除元素().removeElement(new int[]{3,2,2,3},3));
    }
}
