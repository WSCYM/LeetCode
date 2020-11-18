package array;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int i=0,left=0,right=nums.length-1;
        while (i<=right){
            if (nums[i]==0){
                nums[i] = nums[left];
                nums[left++]=0;
                i++;
            } else if (nums[i]==2){
                nums[i]=nums[right];
                nums[right--]=2;
            } else {
                i++;
            }
        }
//        int cnt0=0,cnt1=0;
//        for (int i : nums){
//            if (i==0){
//                cnt0++;
//            }
//            if (i==1){
//                cnt1++;
//            }
//        }
//        for (int i = 0 ;i<nums.length;i++){
//            if (cnt0>0){
//                nums[i]=0;
//                cnt0--;
//                continue;
//            }
//            if (cnt1>0){
//                nums[i]=1;
//                cnt1--;
//                continue;
//            }
//            nums[i] = 2;
//        }
    }

    public static void main(String[] args) {
        int[] res = {2, 0, 2, 1, 1, 0};
        new 颜色分类().sortColors(res);
        for (int i : res){
            System.out.println(i);
        }
    }
}
