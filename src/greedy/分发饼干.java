package greedy;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int p = 0;
        for (int i : g){
            while ( p<s.length &&i>s[p] ){
                p++;
            }
            if (p!=s.length) {
                p++;
                res++;
            }
        }
        return res;
    }
}
