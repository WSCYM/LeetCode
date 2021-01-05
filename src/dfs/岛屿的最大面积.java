package dfs;

import java.util.Stack;

public class 岛屿的最大面积 {


    //dfs+栈+visited
//    int[][] visited;
//    int res = 0;
//    public int maxAreaOfIsland(int[][] grid) {
//        visited = new int[grid.length][grid[0].length];
//        for (int i = 0;i<grid.length;i++){
//            for (int j = 0;j<grid[0].length;j++){
//                if (grid[i][j]==1 && visited[i][j]==0){
//                    int cnt = dfs(grid, i, j, visited);
//                    if (cnt>res){
//                        res = cnt;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//    int dfs(int[][] grid,int i,int j,int[][] visited){
//        int cnt = 0;
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{i,j});
//        visited[i][j]=1;
//        while (!stack.isEmpty()){
//            int[] pop = stack.pop();
//            cnt++;
//            if (pop[0]>0 && grid[pop[0]-1][pop[1]]==1 && visited[pop[0]-1][pop[1]]==0){
//                stack.push(new int[]{pop[0]-1,pop[1]});
//                visited[pop[0]-1][pop[1]]=1;
//            }
//            if (pop[1]>0 && grid[pop[0]][pop[1]-1]==1 && visited[pop[0]][pop[1]-1]==0){
//                stack.push(new int[]{pop[0],pop[1]-1});
//                visited[pop[0]][pop[1]-1]=1;
//            }
//            if (pop[0]<grid.length-1 && grid[pop[0]+1][pop[1]]==1 && visited[pop[0]+1][pop[1]]==0){
//                stack.push(new int[]{pop[0]+1,pop[1]});
//                visited[pop[0]+1][pop[1]]=1;
//            }
//            if (pop[1]<grid[0].length-1 && grid[pop[0]][pop[1]+1]==1 && visited[pop[0]][pop[1]+1]==0){
//                stack.push(new int[]{pop[0],pop[1]+1});
//                visited[pop[0]][pop[1]+1]=1;
//            }
//        }
//        return cnt;
//    }



    //dfs+栈
//    int res = 0;
//    public int maxAreaOfIsland(int[][] grid) {
//        for (int i = 0;i<grid.length;i++){
//            for (int j = 0;j<grid[0].length;j++){
//                if (grid[i][j]==1 ){
//                    int cnt = dfs(grid, i, j);
//                    if (cnt>res){
//                        res = cnt;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    int dfs(int[][] grid,int i,int j){
//        int cnt = 0;
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{i,j});
//        grid[i][j] = 0;
//        while (!stack.isEmpty()){
//            int[] pop = stack.pop();
//            cnt++;
//            if (pop[0]>0 && grid[pop[0]-1][pop[1]]==1){
//                stack.push(new int[]{pop[0]-1,pop[1]});
//                grid[pop[0]-1][pop[1]] = 0;
//            }
//            if (pop[1]>0 && grid[pop[0]][pop[1]-1]==1){
//                stack.push(new int[]{pop[0],pop[1]-1});
//                grid[pop[0]][pop[1]-1] = 0;
//            }
//            if (pop[0]<grid.length-1 && grid[pop[0]+1][pop[1]]==1){
//                stack.push(new int[]{pop[0]+1,pop[1]});
//                grid[pop[0]+1][pop[1]] = 0;
//            }
//            if (pop[1]<grid[0].length-1 && grid[pop[0]][pop[1]+1]==1){
//                stack.push(new int[]{pop[0],pop[1]+1});
//                grid[pop[0]][pop[1]+1] = 0;
//            }
//        }
//        return cnt;
//    }

    //dfs+递归+递归前判断越界
//    int res = 0;
//    int cnt = 0;
//    public int maxAreaOfIsland(int[][] grid) {
//        for (int i = 0;i<grid.length;i++){
//            for (int j = 0;j<grid[0].length;j++){
//                if (grid[i][j]==1 ){
//                    dfs(grid, i, j);
//                    if (cnt>res){
//                        res = cnt;
//                    }
//                    cnt = 0;
//                }
//            }
//        }
//        return res;
//    }
//
//    void dfs(int[][] grid,int i,int j){
//        grid[i][j] = 0;
//        cnt++;
//        if (i>0 && grid[i-1][j]==1){
//            dfs(grid,i-1,j);
//        }
//        if (j>0 && grid[i][j-1]==1){
//            dfs(grid,i,j-1);
//        }
//        if (i<grid.length-1 && grid[i+1][j]==1){
//            dfs(grid,i+1,j);
//        }
//        if (j<grid[0].length-1 && grid[i][j+1]==1){
//            dfs(grid,i,j+1);
//        }
//    }

        //dfs+递归+递归后判断越界
        int res = 0;
        public int maxAreaOfIsland(int[][] grid) {
            for (int i = 0;i<grid.length;i++){
                for (int j = 0;j<grid[0].length;j++){
                    if (grid[i][j]==1 ){
                        int cnt = dfs(grid, i, j);
                        if (cnt>res){
                            res = cnt;
                        }
                    }
                }
            }
            return res;
        }

        int dfs(int[][] grid,int i,int j){
            if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
                return 0;
            }
            grid[i][j] = 0;
            return 1 + dfs(grid,i-1,j) + dfs(grid,i,j-1) + dfs(grid,i+1,j)+dfs(grid,i,j+1);
        }

    public static void main(String[] args) {
        System.out.println(new 岛屿的最大面积().maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }
}
