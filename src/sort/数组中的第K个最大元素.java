package sort;

import java.util.*;

public class 数组中的第K个最大元素 {
    //选择排
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

    //快排
//    int res;
//    Random random = new Random();
//    public int findKthLargest(int[] nums, int k) {
//        int l = 0;
//        int r = nums.length-1;
//        shAndpartition(nums,l,r,k);
//        return res;
//    }
//
//    void shAndpartition(int[] nums,int l,int r,int k){
//        if (l!=r){
//            int idx = l+random.nextInt(r-l);
//            int tmp = nums[idx];
//            nums[idx] = nums[l];
//            nums[l] = tmp;
//        }
//        partition(nums,l,r,k);
//    }
//
//    void partition(int[] nums,int l,int r,int k){
//        if (l>r){
//            return;
//        }
//        int left = l,right = r;int key = nums[l];
//        while (left<right){
//            while (left<right && nums[right]<=key){
//                right--;
//            }
//            nums[left] = nums[right];
//            while (left<right && nums[left]>=key){
//                left++;
//            }
//            nums[right] = nums[left];
//        }
//        nums[left] = key;
//        if (left == k-1){
//            res = key;
//            return;
//        } else if (left<k-1){
//            partition(nums,left+1,r,k);
//        } else if (left>k-1){
//            partition(nums,l,left-1,k);
//        }
//    }

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = heapSize-1;i>=0;i--){
            swap(nums,0,heapSize-1);
            if (nums.length-heapSize==k){
                break;
            }
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }
        return nums[heapSize];
    }

    public void buildMaxHeap(int[] nums,int heapSize){
        for (int i = nums.length/2;i>=0;i--){
            maxHeapify(nums,i,heapSize);
        }
    }

    public void maxHeapify(int[] a,int i,int heapSize){
        int l=2*i+1;
        int r = 2*i+2;
        int largest = i;
        if (l<heapSize && a[l]>a[largest]){
            largest = l;
        }
        if (r<heapSize && a[r]>a[largest]){
            largest = r;
        }
        if (largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new 数组中的第K个最大元素().findKthLargest(nums,3));
    }

}
