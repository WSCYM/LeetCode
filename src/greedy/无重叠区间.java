package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] arr:intervals){
            if (arr[0]<end) {
                count++;
            } else {
                end = arr[1];
            }
        }
        return count;
    }
}
