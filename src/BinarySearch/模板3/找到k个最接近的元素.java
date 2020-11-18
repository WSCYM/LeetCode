package BinarySearch.模板3;

import java.util.ArrayList;
import java.util.List;

public class 找到k个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0,right = arr.length-1;
        List<Integer> res = new ArrayList<>();
        if (arr.length==1){
            res.add(arr[0]);
            return res;
        }
        while (left<right){
            int mid = left + (right - left)/2;
            if (arr[mid]<x){
                left = mid+1;
            } else {
                right =mid;
            }
        }
        int low=left,high=left;
        //arr[left] 为大于等于x的第一个值
        if (left>0 && x-arr[left-1]<=arr[left]-x){
            low = left-1;high = left-1;
        }
        while (high-low+1<k){
            if (low==0){
                high++;
                continue;
            }
            if (high==arr.length-1){
                low--;
                continue;
            }
            if (x-arr[low-1]<=arr[high+1]-x){
                low--;
            } else {
                high++;
            }
        }
        while (low<=high){
            res.add(arr[low]);
            low++;
        }
        return res;
    }

    public static void main(String[] args) {
        new 找到k个最接近的元素().findClosestElements(new int[]{0,0,0,1,3,5,6,7,8,8},2,2);
    }
}
