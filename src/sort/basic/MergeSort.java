package sort.basic;

import java.util.Arrays;

public class MergeSort {
    //左闭右开
    void sort(int[] nums,int l,int r,int[] temp){
        if (l+1>=r){
            return;
        }
        int m = l+(r-l)/2;
        sort(nums,l,m,temp);
        sort(nums,m,r,temp);
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
}
