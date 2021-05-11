package JZOffer;

public class 数组中的逆序对 {
    int[] tmp,nums;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort (0,nums.length-1);
    }

    private int mergeSort(int l,int r){
        if (l>=r) return 0;
        int m = (l+r)/2;
        int res = mergeSort(l,m)+mergeSort(m+1,r);
        for (int k=l;k<=r;k++){
            tmp[k] = nums[k];
        }
        int i = l,j=m+1;
        for (int k = l;k<=r;k++){
            if (i==m+1){
                nums[k] = tmp[j++];
            } else if (j==r+1){
                nums[k] = tmp[i++];
            } else if (tmp[i]<=tmp[j]){
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res+=m-i+1;
            }
        }
        return res;
    }
}
