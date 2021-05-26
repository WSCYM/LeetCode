package leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1326 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    List<String> ret;
    HashMap<Character,List<Character>> hashMap;
    String digits;
    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        if (digits.length()==0) return ret;
        hashMap = new HashMap<>();
        this.digits = digits;
        hashMap.put('2', Arrays.asList('a','b','c'));
        hashMap.put('3', Arrays.asList('d','e','f'));
        hashMap.put('4', Arrays.asList('g','h','i'));
        hashMap.put('5', Arrays.asList('j','k','l'));
        hashMap.put('6', Arrays.asList('m','n','o'));
        hashMap.put('7', Arrays.asList('p','q','r','s'));
        hashMap.put('8', Arrays.asList('t','u','v'));
        hashMap.put('9', Arrays.asList('w','x','y','z'));
        StringBuffer path = new StringBuffer();
        backtracking(path,0);
        return ret;
    }

    void backtracking(StringBuffer path,int i){
        if (path.length()==digits.length()){
            ret.add(path.toString());
            return;
        }
        List<Character> characters = hashMap.get(digits.charAt(i));
        for (Character c : characters){
            path.append(c);
            backtracking(path,i+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
