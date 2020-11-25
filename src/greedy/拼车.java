package greedy;

import java.util.*;

public class 拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int[] trip : trips){
            hashMap.put(trip[1],hashMap.getOrDefault(trip[1],0)+trip[0]);
            hashMap.put(trip[2],hashMap.getOrDefault(trip[2],0)-trip[0]);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        ArrayList<Map.Entry<Integer,Integer>> as = new ArrayList<>(entries);
        Collections.sort(as,((o1, o2) -> o1.getKey()-o2.getKey()));
        for (Map.Entry<Integer,Integer> entry : as){
            capacity-=entry.getValue();
            if (capacity<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new 拼车().carPooling(new int[][]{{2,1,5},{3,5,7}},3);
    }
}
