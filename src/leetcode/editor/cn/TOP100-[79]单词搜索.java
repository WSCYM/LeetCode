package leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 925 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean ret = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                dfs(board,i,j,word,0,visited);
            }
        }
        return ret;
    }

    boolean dfs(char[][] board,int posI,int posJ,String word,int idx,boolean[][] visited){
        if (idx==word.length()-1 && board[posI][posJ]==word.charAt(word.length()-1)){
            ret = true;
            return true;
        }

        visited[posI][posJ] = true;
        boolean flag = board[posI][posJ]==word.charAt(idx)
                && (
                (posI-1>=0 && !visited[posI-1][posJ] && dfs(board, posI-1, posJ, word, idx+1,visited))
                ||(posI+1<board.length && !visited[posI+1][posJ] && dfs(board, posI+1, posJ, word, idx+1,visited))
                ||(posJ-1>=0 && !visited[posI][posJ-1] && dfs(board, posI, posJ-1, word, idx+1,visited))
                ||(posJ+1<board[0].length && !visited[posI][posJ+1] && dfs(board, posI, posJ+1, word, idx+1,visited))
                );
        visited[posI][posJ] = false;
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
