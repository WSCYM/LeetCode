package backtrack;


import java.util.ArrayList;
import java.util.List;

public class 解数独 {
    private boolean[][] rowHas = new boolean[9][9];
    private boolean[][] colHas = new boolean[9][9];
    private boolean[][][] blockHas = new boolean[3][3][9];
    private boolean hasAns = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0;i<9;i++){
            for (int j = 0;j<9;j++){
                if (board[i][j]=='.'){
                    spaces.add(new int[]{i,j});
                } else {
                    rowHas[i][board[i][j]-'0'-1] = true;
                    colHas[j][board[i][j]-'0'-1] = true;
                    blockHas[i/3][j/3][board[i][j]-'0'-1] = true;
                }
            }
        }
        backtracking(0,board);
    }

    void backtracking(int idx,char[][] board){
        if (idx>=spaces.size()){
            hasAns=true;
            return;
        }
        int x = spaces.get(idx)[0];
        int y = spaces.get(idx)[1];
        for (int dig = 1;dig<=9 && !hasAns;dig++){
            if (!rowHas[x][dig-1] && !colHas[y][dig-1] && !blockHas[x/3][y/3][dig-1]){
                rowHas[x][dig-1] =colHas[y][dig-1]=blockHas[x/3][y/3][dig-1]= true;
                board[x][y] = (char)(dig+'0');
                backtracking(idx+1,board);
                rowHas[x][dig-1] =colHas[y][dig-1]=blockHas[x/3][y/3][dig-1]= false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        解数独 test = new 解数独();
        test.solveSudoku(board);
    }
}
