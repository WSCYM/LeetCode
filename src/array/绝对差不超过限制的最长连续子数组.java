package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 绝对差不超过限制的最长连续子数组
 * @Description TODO
 * @createTime 2020-11-14 19:59:00
 */
public class 绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> dequeMax = new LinkedList<>();
        Deque<Integer> dequeMin = new LinkedList<>();
        dequeMax.addLast(nums[0]);
        dequeMin.addLast(nums[0]);
        int left=0,right=0,res = 1;
        while (right<nums.length-1){
            right++;
            while (dequeMax.size()>0 && dequeMax.peekLast()<nums[right]){
                dequeMax.removeLast();
            }
            dequeMax.addLast(nums[right]);
            while (dequeMin.size()>0 && dequeMin.peekLast()>nums[right]){
                dequeMin.removeLast();
            }
            dequeMin.addLast(nums[right]);
            if ((dequeMax.peekFirst()-dequeMin.peekFirst())<=limit && res< right-left+1) {
                res = right-left+1;
            }
            while ((dequeMax.peekFirst()-dequeMin.peekFirst())>limit){
                if (dequeMax.peekFirst()==nums[left]){
                    dequeMax.removeFirst();
                }
                if (dequeMin.peekFirst()==nums[left]){
                    dequeMin.removeFirst();
                }
                left++;
            }
        }
        return res;
    }

//    public int longestSubarray(int[] nums, int limit) {
//        int left=0,right=0,res = 1;
//        while (right<nums.length-1){
//            right++;
//            if ((getDiff(nums,left,right))<=limit && res< right-left+1) {
//                res = right-left+1;
//            }
//            while (getDiff(nums,left,right)>limit){
//                left++;
//            }
//        }
//        return res;
//    }
//
//    int getDiff(int[] nums,int left,int right){
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int i = left;i<=right;i++){
//            if ((nums[i])<min){
//                min = nums[i];
//            }
//            if ((nums[i])>max){
//                max = nums[i];
//            }
//        }
//        return Math.abs(max-min);
//    }

    public static void main(String[] args) {
        new 绝对差不超过限制的最长连续子数组().longestSubarray(new int[]{8,2,4,7},4);
    }
}
