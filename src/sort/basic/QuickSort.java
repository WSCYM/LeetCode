package sort;

public class QuickSort {
    //左闭右开
    public void quickSort(int[] nums,int l,int r){
        if (l+1>=r){
            return;
        }
        int first = l;int last = r-1;int key = nums[first];
        while (first<last){
            while (first<last && nums[last]>=key){
                last--;
            }
            nums[first] = nums[last];
            while (first<last && nums[first]<=key){
                first++;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quickSort(nums,l,first);
        quickSort(nums,first+1,r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,2,6,4,8,9,2,8,7,6,0,3,5,9,4,1,0};
        new QuickSort().quickSort(nums,0,nums.length);
        for (int i : nums){
            System.out.println(i);
        }
    }
}
