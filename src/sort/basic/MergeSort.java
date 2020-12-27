package sort;

import java.util.Arrays;

public class MergeSort {
    //左闭右开
    void mergeSort(int[] nums,int l,int r,int[] temp){
        if (l+1>=r){
            return;
        }
        int m = l+(r-l)/2;
        mergeSort(nums,l,m,temp);
        mergeSort(nums,m,r,temp);
        int p=l,q=m,i=l;
        while (p<m || q<r){
            if (q>=r || (p<m && nums[p]<nums[q])){
                temp[i++] = nums[p++];
            } else {
                temp[i++] = nums[q++];
            }
        }
        for (i=l;i<r;i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        new MergeSort().mergeSort(nums,0,nums.length,new int[nums.length]);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
