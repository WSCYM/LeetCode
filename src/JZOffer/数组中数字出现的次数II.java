package JZOffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entry = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue()==1){
                return next.getKey();
            }
        }
        return -1;
    }
}
