package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 根据字符出现频率排序 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length()];
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c : chars){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        List<Character>[] b = new List[chars.length+1];
        for (Character c : hashMap.keySet()){
            if (b[hashMap.get(c)]==null) b[hashMap.get(c)] = new ArrayList<>();
            b[hashMap.get(c)].add(c);
        }
        int i = 0;
        for (int j = b.length-1;j>0;j--){
            if (b[j]==null) continue;
            for (Character c : b[j]){
                for (int k=0;k<j;k++){
                    res[i]=c;
                    i++;
                }
            }
        }
        return String.valueOf(res);
    }
}
