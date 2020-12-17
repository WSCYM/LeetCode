package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
//    List<String> res = new ArrayList<>();
//    public List<String> letterCasePermutation(String S) {
//        backtrack(S.toCharArray(),new StringBuffer(),0);
//        return res;
//    }
//
//    void backtrack(char[] chars,StringBuffer path,int start){
//        if (path.length()==chars.length){
//            res.add(path.toString());
//            return;
//        }
//
//        for (int i = start;i<chars.length;i++){
//            if (chars[i]>='0' && chars[i]<='9'){
//                path.append(chars[i]);
//                backtrack(chars,path,i+1);
//                path.deleteCharAt(path.length()-1);
//            } else {
//                path.append(chars[i]);
//                backtrack(chars,path,i+1);
//                path.deleteCharAt(path.length()-1);
//                if (chars[i]>='a' && chars[i]<='z'){
//                    chars[i] +='A'-'a';
//                } else {
//                    chars[i] -='A'-'a';
//                }
//                path.append(chars[i]);
//                backtrack(chars,path,i+1);
//                path.deleteCharAt(path.length()-1);
//            }
//        }
//    }
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(),0);
        return res;
    }

    void dfs(char[] chars,int idx){
        if (idx == chars.length){
            res.add(String.valueOf(chars));
            return;
        }

        dfs(chars,idx+1);
        if (Character.isLowerCase(chars[idx])){
            chars[idx] = Character.toUpperCase(chars[idx]);
            dfs(chars,idx+1);
        }else if (Character.isUpperCase(chars[idx])){
            chars[idx] = Character.toLowerCase(chars[idx]);
            dfs(chars,idx+1);
        }
    }
}
