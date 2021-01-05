package dfs;

public class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0;i<isConnected.length;i++){
            if (!visited[i]) {
                res++;
                dfs(i,visited,isConnected);
            }
        }
        return res;
    }

    void dfs(int i,boolean[] visited,int[][] isConnected){
        visited[i] = true;
        for (int j = 0;j<isConnected.length;j++){
            if (isConnected[i][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }
}
