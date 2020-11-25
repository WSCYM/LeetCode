package greedy;

import java.util.Arrays;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] A, int K) {
        for (int i = 0;i<K;i++){
            int minIdx = 0;
            for (int j = 0;j<A.length;j++){
                if (A[minIdx]>A[j]){
                    minIdx = j;
                }
            }
            A[minIdx] = -A[minIdx];
        }
        int sum = 0;
        for (int i = 0;i<A.length;i++){
            sum+=A[i];
        }
        return sum;
    }
}
