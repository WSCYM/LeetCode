package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 杨辉三角
 * @Description TODO
 * @createTime 2020-12-06 14:10:00
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows==0) return list;
        ArrayList<Integer> as = new ArrayList<>();
        as.add(1);
        list.add(as);
        for (int i = 1;i < numRows;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0;j<i+1;j++){
                if (j==0 || j==i){
                    tmp.add(1);
                } else {
                    tmp.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
