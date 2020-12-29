package sort;

import java.util.*;

public class 数组中的第K个最大元素 {
//    public int findKthLargest(int[] nums, int k) {
//        int idx;
//        for (int i = 0;i<k;i++){
//            idx = i;
//            for (int j=i+1;j<nums.length;j++){
//                if (nums[j]>nums[idx]){
//                    idx = j;
//                }
//            }
//            int tmp = nums[i];
//            nums[i] = nums[idx];
//            nums[idx] = tmp;
//        }
//        return nums[k-1];
//    }
    int res;
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        shAndpartition(nums,l,r,k);
        return res;
    }

    void shAndpartition(int[] nums,int l,int r,int k){
        if (l!=r){
            int idx = l+random.nextInt(r-l);
            int tmp = nums[idx];
            nums[idx] = nums[l];
            nums[l] = tmp;
        }
        partition(nums,l,r,k);
    }

    void partition(int[] nums,int l,int r,int k){
        if (l>r){
            return;
        }
        int left = l,right = r;int key = nums[l];
        while (left<right){
            while (left<right && nums[right]<=key){
                right--;
            }
            nums[left] = nums[right];
            while (left<right && nums[left]>=key){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        if (left == k-1){
            res = key;
            return;
        } else if (left<k-1){
            partition(nums,left+1,r,k);
        } else if (left>k-1){
            partition(nums,l,left-1,k);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new 数组中的第K个最大元素().findKthLargest(nums,3));
    }

}
