package backtrack;

import java.util.HashSet;

public class 活字印刷 {
    HashSet<String> hashSet = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        StringBuffer sb = new StringBuffer();
        backtrack(sb,tiles.toCharArray(),new boolean[7]);
        return hashSet.size();
    }

    void backtrack(StringBuffer sb,char[] chars,boolean[] visit){
        if (sb.length()!=0)
        hashSet.add(sb.toString());

        for (int i = 0;i<chars.length;i++){
            if (!visit[i]){
                sb.append(chars[i]);
                visit[i] = true;
                backtrack(sb,chars,visit);
                visit[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new 活字印刷().numTilePossibilities("A");
    }
}
