package JZOffer;

import java.util.HashMap;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        char c = 0;
        boolean hasSame = false;
        int maxNum = -1;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap();
        while (right<chars.length){
            hashMap.put(chars[right],hashMap.getOrDefault(chars[right],0)+1);
            if (hashMap.get(chars[right])>1){
                c = chars[right];
                hasSame = true;
            }
            if (!hasSame && right - left> maxNum){
                maxNum = right-left; }
            right++;
            while (hasSame){
                hashMap.put(chars[left],hashMap.get(chars[left])-1);
                if (chars[left]==c){
                    hasSame = false;
                }
                left++;
            }
        }
        return maxNum+1;
    }

    public static void main(String[] args) {
        System.out.println(new 最长不含重复字符的子字符串().lengthOfLongestSubstring("tmmzuxt"));;
    }
}
