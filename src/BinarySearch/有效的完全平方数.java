package BinarySearch;

public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        int left = 1,right = num/2;
        while (left<=right){
            int mid = left+(right-left)/2;
            if ((long)mid*mid == num){
                return true;
            } else if ((long)mid*mid>num){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(808201));
        System.out.println(new 有效的完全平方数().isPerfectSquare(808201));
    }
}
