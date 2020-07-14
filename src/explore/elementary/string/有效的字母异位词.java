package explore.elementary.string;

import java.util.HashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 有效的字母异位词
 * @Description
 *
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @createTime 2020-07-14 19:44:00
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i = 0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0;i<t.length();i++){
            if (hashMap.get(t.charAt(i))!= null && hashMap.get(t.charAt(i))!=0){
                hashMap.put(t.charAt(i),hashMap.get(t.charAt(i))-1);
            }
        }
        for (int i = 0;i<s.length();i++){
            if (hashMap.get(s.charAt(i))!=0){
                return false;
            }
        }
        return true;
    }
}
