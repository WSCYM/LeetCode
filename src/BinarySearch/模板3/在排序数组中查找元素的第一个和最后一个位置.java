package BinarySearch.模板3;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0 || target<nums[0] || target>nums[nums.length-1]) {
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                right = mid;
            } else if (nums[mid]>target){
                right = mid;
            } else if (nums[mid]<target){
                left = mid + 1;
            }
        }
        int resL = left;
        left = 0;
        right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target){
                left = mid+1;
            } else if (nums[mid]>target){
                right = mid;
            } else if (nums[mid]<target){
                left = mid + 1;
            }
        }
        int resR = right-1;
        if (resL>resR) return new int[]{-1,-1};
        return new int[]{resL,resR};
    }






//    public int[] searchRange(int[] nums, int target) {
//        int left = 0,right = nums.length-1;
//        int[] res = new int[]{-1,-1};
//        if (nums.length==0){
//             return res;
//        }
//        while (left<right){
//            int mid = (right-left)/2+left;
//            if (nums[mid]<target){
//                left = mid+1;
//            } else {
//                right = mid;
//            }
//        }
//        if (nums[left]==target){
//            res[0] = left;
//        }
//        left = 0;right = nums.length-1;
//        while (left<right){
//            int mid = (right-left)/2+left;
//            if (nums[mid]<=target){
//                left = mid+1;
//            } else {
//                right = mid;
//            }
//        }
//        if (left!=0){
//            if (nums[left-1]==target){
//                res[1] = left-1;
//            }
//        }
//        if (nums[left]==target){
//            res[1] = left;
//        }
//        return res;
//    }
}
