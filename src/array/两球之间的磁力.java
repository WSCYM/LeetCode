package array;

import java.util.Arrays;

public class 两球之间的磁力 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1,max = position[position.length-1]-position[0];
        int res = 0;
        while (min<=max){
            int mid = min+(max-min)/2;
            if (check(mid,position,m)){
                res = mid;
                min=mid+1;
            } else {
                max = mid-1;
            }
        }
        return res;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
