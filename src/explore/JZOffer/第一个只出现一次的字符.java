package explore.JZOffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap();
        for (char c : cs){
            linkedHashMap.put(c,linkedHashMap.getOrDefault(c,0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries){
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
