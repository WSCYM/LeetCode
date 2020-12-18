package string;

import java.util.HashMap;

public class 找不同 {
    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap();
        for (Character c : ss){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        for (Character c : tt){
            if (hashMap.getOrDefault(c,0)==0){
                return c.charValue();
            }
            hashMap.put(c,hashMap.get(c)-1);
        }
        return 1;
    }
}
