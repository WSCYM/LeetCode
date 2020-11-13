package array;

import java.util.Arrays;

public class 有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        int[] b = new int[A.length];
        for (int i=0;i<A.length;i++){
            b[i] = A[i]*A[i];
        }
        Arrays.sort(b);
        return b;
    }
}
