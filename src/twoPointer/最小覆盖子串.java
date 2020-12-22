package twoPointer;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class 最小覆盖子串 {
    //算法思想：
    //用一个needHashMap记录每个字母还需要多少次才能覆盖子串;
    //right一直向右滑动，若遇到needHashMap中的字母，则needHashMap中对应的字母数-1;
    //当满足以下两个条件之一时，left向左滑动:
    //    1)子串中不包含left位置的字母
    //    2)当前窗口中的left位置的字母个数大于字串中该字的母个数
    //用length变量记录长度，若当前窗口满足条件并且长度小于length，则更新length与保存结果左右指针的变量;
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int resL = 0;
        int resR = -1;
        LinkedHashMap<Character,Integer> needHashMap = new LinkedHashMap<>();
        int left = 0;
        int right = 0;
        //初始化needHashMap
        for (char c : tt){
            needHashMap.put(c,needHashMap.getOrDefault(c,0)+1);
        }
        int length = Integer.MAX_VALUE;
        while (right<ss.length){
            //若遇到needHashMap中的字母，则needHashMap中对应的字母数-1
            if (needHashMap.containsKey(ss[right])) needHashMap.put(ss[right],needHashMap.get(ss[right])-1);
            right++;
            if (check(needHashMap)){//若当前窗口可以覆盖子串，则判断left是否向右滑动以及是否需要更新结果变量
                //判断是否向左滑动
                while (!needHashMap.containsKey(ss[left]) || needHashMap.get(ss[left])<0){
                    if (needHashMap.containsKey(ss[left])){
                        needHashMap.put(ss[left],needHashMap.get(ss[left])+1);
                    }
                    left++;
                }
                //判断是否需要更新结果变量
                if (length>right-left+1){
                    resL = left;
                    resR = right-1;
                    length = right-left+1;
                }
            }
        }
        if (resL<=resR){
            StringBuffer sb = new StringBuffer();
            for (int i = resL;i<=resR;i++){
                sb.append(ss[i]);
            }
            return sb.toString();
        }
        return "";
    }

    //判断当前窗口是可以覆盖字串，若needHash中包含大于0的值，则不可以覆盖，否则可以覆盖
    boolean check(LinkedHashMap<Character,Integer> needHashMap){
        Iterator<Integer> iterator = needHashMap.values().iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new 最小覆盖子串().minWindow("adfas"
                ,"asf");
    }
}
