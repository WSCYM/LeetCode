package string;

import java.util.ArrayList;
import java.util.List;

public class 较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1;i<chars.length;i++){
            if (chars[i]==chars[i-1]){
                end++;
                if (i==chars.length-1){
                    if (end-start>=2){
                        List<Integer> list = new ArrayList<>();
                        list.add(start);
                        list.add(end);
                        res.add(list);
                    }
                }
            }
            else {
                if (end-start>=2){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
                start=i;
                end=i;
            }
        }
        return res;
    }
}
