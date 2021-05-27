package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1801 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        backtracking(path,0,0,n);
        return ret;
    }

    void backtracking(StringBuffer path,int i,int countL,int n){
        if (i==n*2){
            if (countL==0){
                ret.add(path.toString());
            }
            return;
        }
            path.append('(');
            backtracking(path,i+1,countL+1,n);
            path.deleteCharAt(path.length()-1);
        if (countL>0){
            path.append(')');
            backtracking(path,i+1,countL-1,n);
            path.deleteCharAt(path.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
