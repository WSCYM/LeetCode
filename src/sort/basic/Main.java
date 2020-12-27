package sort.basic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
//        new sort().mergeSort(nums,0,nums.length,new int[nums.length]);
//        new sort().quickSort(nums,0,nums.length);
//        new sort().insertionSort(nums,nums.length);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
