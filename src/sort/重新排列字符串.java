package sort;

import java.util.Arrays;

public class 重新排列字符串 {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0;i<chars.length;i++){
            res[indices[i]] = chars[i];
        }
        return String.valueOf(res);
    }
}
