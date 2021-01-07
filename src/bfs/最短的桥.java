package bfs;

import backtrack.组合;

import java.util.*;

public class 最短的桥 {
    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int shortestBridge(int[][] A) {
        Deque<int[]> deque = new LinkedList<>();
        boolean flag = true;
        for (int i = 0;i<A.length && flag;i++){
            for (int j = 0;j<A[0].length;j++){
                if (A[i][j]==1){
                    flag = false;
                    dfs(A,i,j,deque);
                    break;
                }
            }
        }
        int step = -1;
        while (!deque.isEmpty()){
            step++;
            int size = deque.size();
            for (int i = 0;i<size;i++){
                int[] remove = deque.remove();
                for (int j = 0;j<4;j++){
                    int x = remove[0]+dir[j][0];
                    int y = remove[1]+dir[j][1];
                    if (x<0||y<0||x>=A.length||y>=A[0].length || A[x][y]==2){
                        continue;
                    }
                    if (A[x][y]==1){
                        return step;
                    }
                    if (A[x][y]==0){
                        A[x][y]=2;
                        deque.add(new int[]{x,y});
                    }
                }
            }
        }
        return -1;
    }
    private void dfs(int [][]A,int i,int j,Deque<int[]> queue){
        if (i<0||i>=A.length||j<0||j>=A[0].length||A[i][j]!=1){
            return;
        }
        queue.add(new int[]{i,j});
        A[i][j] = 2;
        dfs(A,i-1,j,queue);
        dfs(A,i+1,j,queue);
        dfs(A,i,j+1,queue);
        dfs(A,i,j-1,queue);
    }

    public static void main(String[] args) {
        new 最短的桥().shortestBridge(new int[][]{{0,1},{1,0}});
    }
}
