package BinarySearch.模板1;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 搜索旋转排序数组
 * @Description TODO
 * @createTime 2020-11-17 19:48:00
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            } else {
                if (nums[mid]>=nums[left]){
                        //左半部分有序
                    if (nums[mid]>target && nums[left]<=target){
                        //target在左半部分
                        right = mid-1;
                    } else {
                        left = mid+1;
                    }
                } else {
                    //右半部分有序
                    if (nums[mid]<target && nums[right]>=target){
                        //target在右半部分
                        left = mid+1;
                    } else {
                        right = mid-1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 搜索旋转排序数组().search(new int[]{3,1},1));
    }
}
