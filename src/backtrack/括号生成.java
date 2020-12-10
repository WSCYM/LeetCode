package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 括号生成 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        LinkedList<Character> track = new LinkedList<>();
        backtrack(0,2*n,0,track);
        return res;
    }
    void backtrack(int start,int n,int cntL, LinkedList<Character> track){
        if (cntL<0){
            return;
        }
        if (track.size()==n && cntL!=0){
            return;
        }
        if (track.size()==n){
            StringBuffer sb = new StringBuffer();
            for (Character c : track){
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = start;i<n;i++){
            for (int j=0;j<=1;j++){
                if (j==0){
                    track.add('(');
                    backtrack(i+1,n,cntL+1,track);
                } else if (j==1){
                    track.add(')');
                    backtrack(i+1,n,cntL-1,track);
                }
                track.removeLast();
            }
        }
    }
}
