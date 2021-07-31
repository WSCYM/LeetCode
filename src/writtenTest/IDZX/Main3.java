package writtenTest.IDZX;

import java.util.ArrayList;
import java.util.Collections;

public class Main3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param timeSchedule string字符串ArrayList<ArrayList<>>
     * @return int整型
     */
    public int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        if (timeSchedule.size()==0) return 0;
        Collections.sort(timeSchedule,((o1, o2) -> {
            return o1.get(1).compareTo(o2.get(1));
        }));
        int ret = 1;
        int tmpIdx = 0;
        for (int i = 1;i<timeSchedule.size();i++){
            if (timeSchedule.get(i).get(0).compareTo(timeSchedule.get(tmpIdx).get(1))<0){
                continue;
            } else {
                ret++;
                tmpIdx = i;
            }
        }
        return ret;
    }
}
