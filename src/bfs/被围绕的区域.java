package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 被围绕的区域 {
    public void solve(char[][] board) {
        if (board.length==0 || board[0].length==0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[][] not2X = new boolean[board.length][board[0].length];
        for (int j = 0;j<board[0].length;j++){
            if (board[0][j]=='O' && !visited[0][j]){
                bfs(0,j,visited,not2X,board);
            }
            if (board[board.length-1][j]=='O' && !visited[board.length-1][j]){
                bfs(board.length-1,j,visited,not2X,board);
            }
        }
        for (int i = 0;i<board.length;i++){
            if (board[i][0]=='O' && !visited[i][0]){
                bfs(i,0,visited,not2X,board);
            }
            if (board[i][board[0].length-1]=='O' && !visited[i][board[0].length-1]){
                bfs(i,board[0].length-1,visited,not2X,board);
            }
        }
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (board[i][j]=='O' && !not2X[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void bfs(int posX,int posY,boolean[][] visited,boolean[][] not2X,char[][] board){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{posX,posY});
        visited[posX][posY] = true;
        not2X[posX][posY] = true;
        while (!queue.isEmpty()){
            int[] remove = queue.remove();
            int x = remove[0];
            int y = remove[1];
            if (x>0 && !visited[x-1][y] && board[x-1][y]=='O'){
                queue.add(new int[]{x-1,y});
                visited[x-1][y] = true;
                not2X[x-1][y] = true;
            }
            if (y>0 && !visited[x][y-1] && board[x][y-1]=='O'){
                queue.add(new int[]{x,y-1});
                visited[x][y-1] = true;
                not2X[x][y-1] = true;
            }
            if (x<board.length-1 && !visited[x+1][y] && board[x+1][y]=='O'){
                queue.add(new int[]{x+1,y});
                visited[x+1][y] = true;
                not2X[x+1][y] = true;
            }
            if (y<board[0].length-1 && !visited[x][y+1] && board[x][y+1]=='O'){
                queue.add(new int[]{x,y+1});
                visited[x][y+1] = true;
                not2X[x][y+1] = true;
            }
        }
    }

    public static void main(String[] args) {
        new 被围绕的区域().solve(
                new char[][]{
                        {'X','O','X','O','X','O'},
                        {'O','X','O','X','O','X'},
                        {'X','O','X','O','X','O'},
                        {'O','X','O','X','O','X'}
                }
                );
    }
}
