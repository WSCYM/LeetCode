package explore.elementary.string;

import java.util.HashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 字符串中的第一个唯一字符
 * @Description
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @createTime 2020-07-11 19:39:00
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.get(s.charAt(i))==null?1:map.get(s.charAt(i))+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
