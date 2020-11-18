package BinarySearch.模板2;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class 第一个错误的版本 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    //写一下防报错
    boolean isBadVersion(int version){
        return false;
    }
}
