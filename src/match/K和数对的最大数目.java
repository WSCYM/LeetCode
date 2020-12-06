package match;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName K和数对的最大数目
 * @Description TODO
 * @createTime 2020-12-06 10:36:00
 */
public class K和数对的最大数目 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int i : nums){
           if (hashMap.containsKey(k-i) && hashMap.get(k-i)>0){
               hashMap.put(k-i,hashMap.get(k-i)-1);
               res += 1;
           } else {
               hashMap.put(i,hashMap.getOrDefault(i,0)+1);
           }
        }
        return res;
    }

    public static void main(String[] args) {
        new K和数对的最大数目().maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2},3);
    }
}
