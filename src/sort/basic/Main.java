package sort.basic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
//        new mergeSort().sort(nums,0,nums.length,new int[nums.length]);
//        new quickSort().sort(nums,0,nums.length);
//        new insertionSort().sort(nums,nums.length);
//        new BubbleSort().sort(nums,nums.length);
//        new SelectSort().sort(nums,nums.length);

        //桶排序按频次
//        int[] nums2 = new int[]{1,1,1,9,8,8};
//        int[] sort = new BucketSort().sort(nums2);
//        Arrays.stream(sort).forEach(System.out::println);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
