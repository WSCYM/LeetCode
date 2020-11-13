package array;

public class 所有奇数长度子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0;i<arr.length;i++){
            int left = i;
            int right = arr.length-i-1;
            int left_odd = (left+1)/2;
            int left_even = left/2;
            int right_odd = (right+1)/2;
            int right_even = right/2;
            sum += arr[i]*(left_odd*right_odd+right_even+left_even*right_even+left_even+1);
        }
        return sum;
    }

    public static void main(String[] args) {
        new 所有奇数长度子数组的和().sumOddLengthSubarrays(new int[]{1,4,2,5,3});
    }
}
