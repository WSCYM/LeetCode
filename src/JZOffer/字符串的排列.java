package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 字符串的排列 {
    //未剪枝版
//    HashSet<String> hashSet = new HashSet<>();
//    public String[] permutation(String s) {
//        char[] chars = s.toCharArray();
//        StringBuffer path = new StringBuffer();
//        boolean[] visited = new boolean[chars.length];
//        backtracking(path,chars,visited);
//        String[] ret = new String[hashSet.size()];
//        int i = 0;
//        for (String string:hashSet){
//            ret[i++] = string;
//        }
//        return ret;
//    }
//
//    void backtracking(StringBuffer path,char[] chars,boolean[] visited){
//        if (path.length()==chars.length){
//            hashSet.add(path.toString());
//            return;
//        }
//        for (int i = 0;i<chars.length;i++){
//            if (visited[i]) continue;
//            path.append(chars[i]);
//            visited[i] = true;
//            backtracking(path,chars,visited);
//            visited[i] = false;
//            path.deleteCharAt(path.length()-1);
//        }
//    }

    //添加剪枝
    HashSet<String> hashSet = new HashSet<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        StringBuffer path = new StringBuffer();
        boolean[] visited = new boolean[chars.length];
        Arrays.sort(chars);
        backtracking(path,chars,visited);
        String[] ret = new String[hashSet.size()];
        int i = 0;
        for (String string:hashSet){
            ret[i++] = string;
        }
        return ret;
    }

    void backtracking(StringBuffer path,char[] chars,boolean[] visited){
        if (path.length()==chars.length){
            hashSet.add(path.toString());
            return;
        }
        for (int i = 0;i<chars.length;i++){
            if (visited[i]) continue;
            //如果第i-1个元素与第i个元素相同且第i-1个元素对应的visited为false，说明在在同一层，剪枝
            if (i>0 && chars[i-1]==chars[i] && !visited[i-1]) continue;
            path.append(chars[i]);
            visited[i] = true;
            backtracking(path,chars,visited);
            visited[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
