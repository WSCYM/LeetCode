package BinarySearch.模板1;

public class X的平方根 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left<=right){
            int mid = left+(right-left)/2;
            if ((long)mid*mid<=x && (long)(mid+1)*(mid+1)>x){
                return mid;
            } else if ((long)mid*mid>x){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new X的平方根().mySqrt(2147395599));
    }
}
