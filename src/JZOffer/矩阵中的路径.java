package JZOffer;

public class 矩阵中的路径 {
    boolean[][] visited;
    boolean ret = false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (!ret && board[i][j]==chars[0]){
                    dfs(board,i,j,chars,0,visited);
                }
            }
        }
        return ret;
    }

    void dfs(char[][] board,int i,int j,char[] chars,int pos,boolean[][] visited){
        if (ret) return;
        if (pos>=chars.length-1){
            ret = true;
            return;
        }
        visited[i][j] = true;
        if (i-1>=0 && !visited[i-1][j] && board[i-1][j]==chars[pos+1]){
            dfs(board,i-1,j,chars,pos+1,visited);
        }
        if (j-1>=0 && !visited[i][j-1] && board[i][j-1]==chars[pos+1]){
            dfs(board,i,j-1,chars,pos+1,visited);
        }
        if (i+1< board.length && !visited[i+1][j] && board[i+1][j]==chars[pos+1]){
            dfs(board,i+1,j,chars,pos+1,visited);
        }
        if (j+1< board[0].length && !visited[i][j+1] && board[i][j+1]==chars[pos+1]){
            dfs(board,i,j+1,chars,pos+1,visited);
        }
        visited[i][j] = false;
    }
}
