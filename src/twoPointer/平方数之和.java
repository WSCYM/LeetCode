package twoPointer;

public class 平方数之和 {
//    public boolean judgeSquareSum(int c) {
//        for (int i = 0;i<=Math.sqrt(c);i++){
//            if (Math.sqrt(c-i*i)%1==0){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean judgeSquareSum(int c) {
        for (int i = 0;i<=Math.sqrt(c);i++){
            if (binarySearch(c-i*i)){
                return true;
            }
        }
        return false;
    }

    boolean binarySearch(int n){
        int left = 0;
        int right = (int) Math.sqrt(n)+1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (mid*mid==n){
                return true;
            }else if (mid*mid>n){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 平方数之和().judgeSquareSum(1000000000));
    }
}
