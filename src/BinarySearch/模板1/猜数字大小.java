package BinarySearch.模板1;

/**
 * Forward declaration of guess API.
 * @param\     your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class 猜数字大小 {
    public int guessNumber(int n) {
        int left = 1,right = n;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (guess(mid)==0){
                return mid;
            } else if (guess(mid)==1){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    //防报错写一下
    int guess(int num){
        return 0;
    }
}
