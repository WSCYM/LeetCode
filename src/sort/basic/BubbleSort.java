package sort.basic;

public class BubbleSort {
    void sort(int[] nums,int n){
        boolean swapped;
        for (int i = 1;i<n;i++){
            swapped = false;
            for (int j = 1;j<n-i+1;j++){
                if (nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
    }
}
