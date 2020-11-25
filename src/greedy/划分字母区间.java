package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] chars = S.toCharArray();
//        hashmap记录每个字母最后一次出现的位置
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i<chars.length;i++){
            hashMap.put(chars[i],i);
        }
        int i = 0;
        while (i<chars.length){
            int start = i;
            int end = hashMap.get(chars[i]);
            while (i<=end){
                if (hashMap.get(chars[i])>end){
                    end = hashMap.get(chars[i]);
                }
                i++;
            }
            res.add(i-start);
        }
        return res;
    }

    public static void main(String[] args) {
        new 划分字母区间().partitionLabels("ababcbacadefegdehijhklij");
    }
}
