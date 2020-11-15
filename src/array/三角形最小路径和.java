package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 三角形最小路径和
 * @Description TODO
 * @createTime 2020-11-15 11:11:00
 */
public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
//        f(     row(x),i    )=max(    f(row(x-1),i),f(row(x-1),i-1)    )
        List<int[]> dp = new ArrayList<>();
        int[] row0=new int[]{triangle.get(0).get(0)};
        dp.add(row0);
        for (int i = 1;i<triangle.size();i++){
            int[] row = new int[triangle.get(i).size()];
            row[0] = triangle.get(i).get(0)+dp.get(i-1)[0];
            dp.add(row);
        }
        for (int i = 1;i<triangle.size();i++){
            dp.get(i)[i] = dp.get(i-1)[i-1]+triangle.get(i).get(i);
        }
        for (int i = 1;i<dp.size();i++){
            for (int j = 1;j<i;j++){
                dp.get(i)[j] = triangle.get(i).get(j)+Math.min(dp.get(i-1)[j-1],dp.get(i-1)[j]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i=0;i<triangle.size();i++){
            res = dp.get(triangle.size()-1)[i]<res? dp.get(triangle.size()-1)[i]:res;
        }
        return res;
    }
}
