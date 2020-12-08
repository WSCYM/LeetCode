package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0) return 0;
        if (points.length==1) return 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1];
        int count = 1;
        for (int i = 1;i<points.length;i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
