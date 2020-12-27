package sort.basic;

public class SelectSort {
    void sort(int[] nums,int n){
        int mid;
        for (int i = 0;i<n-1;i++){
            mid = i;
            for (int j = i+1;j<n;j++){
                if (nums[j]<nums[mid]){
                    mid = j;
                }
            }
            int tmp = nums[mid];
            nums[mid] = nums[i];
            nums[i] = tmp;
        }
    }
}
