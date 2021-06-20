package writtenTest;

import java.util.*;

public class KeyString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        List<String> subStrs = getSubStr(str);
        int ret = 0;
        for (String s : subStrs){
            if (isKeyStr(s)) ret++;
        }
        System.out.println(ret);
    }

    public static List<String> getSubStr(String str){
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                ret.add(str.substring(i,j));
            }
        }
        return ret;
    }

    public static boolean isKeyStr(String str){
        if (str.length()==0) return false;
        char[] chars = str.toCharArray();
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();

        for(int i=0; i<chars.length; i++){
            hashMap.put(chars[i],hashMap.getOrDefault(chars[i],0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries){
            if (entry.getValue()*2>chars.length) return true;
        }
        return false;
    }
}
