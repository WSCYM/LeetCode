package BinarySearch;

public class 有序数组中的单一元素 {
//    public int singleNonDuplicate(int[] nums) {
//        //if : nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1] return mid
//        //else if mid is odd :
//        //      if(nums[mid-1]==nums[mid]) : left = mid + 1;
//        //      else : right = mid -1;
//        //else if mid is even:
//        //      if(nums[mid-1]==nums[mid]) : right = mid - 1;
//        //      else : left = mid + 1;
//        if (nums.length==1){
//            return nums[0];
//        }
//        int left = 0;
//        int right = nums.length-1;
//        while (left<=right){
//            int mid = left+(right-left)/2;
//            if (mid==0 && nums[mid]!=nums[mid+1]){
//                return nums[mid];
//            }else if (mid==nums.length-1 && nums[mid]!=nums[mid-1]){
//                return nums[mid];
//            }else if (nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
//                return nums[mid];
//            }
//
//            if (mid%2!=0){
//                if(nums[mid-1]==nums[mid]){
//                    left = mid + 1;
//                } else {
//                    right = mid -1;
//                }
//            }
//            if (mid%2==0){
//                if(nums[mid+1]==nums[mid]){
//                    left = mid + 1;
//                } else {
//                    right = mid -1;
//                }
//            }
//        }
//        return -1;
//    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (mid%2==1) mid--;
            if (nums[mid]==nums[mid+1]){
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
