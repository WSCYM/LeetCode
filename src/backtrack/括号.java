package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 括号 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        r(0,0,n,new StringBuffer());
        return res;
    }

    void r(int cntL,int cntR,int n,StringBuffer sb){
        if (cntL==cntR && cntL ==n){
            res.add(sb.toString());
            return;
        }
        if (cntL<n){
            StringBuffer sb1 = new StringBuffer(sb);
            sb1.append("(");
            r(cntL+1,cntR,n,sb1);
        }
        if (cntL>cntR){
            StringBuffer sb2 = new StringBuffer(sb);
            sb2.append(")");
            r(cntL,cntR+1,n,sb2);
        }
    }
}
