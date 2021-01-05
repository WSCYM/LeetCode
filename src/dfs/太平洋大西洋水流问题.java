package dfs;

import java.util.ArrayList;
import java.util.List;

public class 太平洋大西洋水流问题 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length==0) return res;
        boolean[][] toLeftUp = new boolean[matrix.length][matrix[0].length];
        boolean[][] toRightDown = new boolean[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            dfs(i,0,toLeftUp,matrix);
            dfs(i,matrix[0].length-1,toRightDown,matrix);
        }
        for (int j=0;j<matrix[0].length;j++){
            dfs(0,j,toLeftUp,matrix);
            dfs(matrix.length-1,j,toRightDown,matrix);
        }
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (toLeftUp[i][j]&&toRightDown[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    void dfs(int i,int j,boolean[][] map,int[][] matrix){
        if (i<0 ||j<0||i>=matrix.length||j>=matrix[0].length||map[i][j]){
            return;
        }
        map[i][j] = true;
        if (i>0&&matrix[i][j]<=matrix[i-1][j]){
            dfs(i-1, j, map, matrix);
        }
        if (j>0&&matrix[i][j]<=matrix[i][j-1]){
            dfs(i, j-1, map, matrix);
        }
        if (i<matrix.length-1&&matrix[i][j]<=matrix[i+1][j]){
            dfs(i+1, j, map, matrix);
        }
        if (j<matrix[0].length-1&&matrix[i][j]<=matrix[i][j+1]){
            dfs(i, j+1, map, matrix);
        }
    }
}
