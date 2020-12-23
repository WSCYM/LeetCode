package twoPointer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 通过删除字母匹配到字典里最长单词 {
    String res = "";
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                } else if (o1.length()<o2.length()){
                    return -1;
                } else {
                    return o2.compareTo(o1);
                }
            }
        });
        for (String str:d){
            if (val(s,str) ){
                res = str;
            }
        }
        return res;
    }

    boolean val(String s1,String s2){
        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while (p2<s2s.length && p1<s1s.length){
            if (s1s[p1]==s2s[p2]){
                p2++;
            }
            p1++;
        }
        if (p2==s2s.length){
            return true;
        } else {
            return false;
        }
    }
}
