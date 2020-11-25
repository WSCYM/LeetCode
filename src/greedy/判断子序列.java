package greedy;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ps = 0;
        if (ss.length==0){
            return true;
        }
        for (char c : tt){
            if (c==ss[ps]){
                ps++;
            }
            if (ps == ss.length){
                return true;
            }
        }
        return false;
    }
}
