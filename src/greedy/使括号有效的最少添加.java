package greedy;

import java.util.Stack;

public class 使括号有效的最少添加 {
    public int minAddToMakeValid(String S) {
        int countL = 0,res = 0;
        char[] chars = S.toCharArray();
        for (char c : chars){
            if (c=='('){
                countL++;
            } else {
                if (countL>0){
                    countL--;
                } else {
                    res++;
                }
            }
        }
        return res+countL;
    }
}
