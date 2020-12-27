package sort;

public class InsertionSort {
    void insertionSort(int[] nums,int n){
        for (int i = 0;i<n;i++){
            for (int j = i;j>0 && nums[j]<nums[j-1];j--){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
    }
}
