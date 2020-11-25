package greedy;

import java.util.*;

public class 数组大小减半 {
    public int minSetSize(int[] arr) {
        int count = 1;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : arr){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> as = new ArrayList<>(hashMap.values());
        Collections.sort(as,((o1, o2) -> o2-o1));
        int res = 0;
        int sum = 0;
        for (Integer i : as){
            sum+=i;
            res++;
            if (sum>=arr.length/2){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new 数组大小减半().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
    }
}
