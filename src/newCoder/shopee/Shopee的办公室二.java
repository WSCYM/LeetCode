package newCoder.shopee;

import java.util.Scanner;

public class Shopee的办公室二 {
    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        boolean[][] visited = new boolean[x+1][y+1];
        for (int i =0;i<n;i++){
            int posX = sc.nextInt();
            int posY = sc.nextInt();
            visited[posX][posY] = true;
        }
        dfs(0,0,visited);
        System.out.println(ret);
    }

    public static void dfs(int i,int j,boolean[][] visited){
        if (i<0 || i>= visited.length || j<0 || j>=visited[0].length){
            return;
        }
        if (i==visited.length-1 && j==visited[0].length-1){
            ret++;
            return;
        }
        if (visited[i][j]){
            return;
        }
        dfs(i+1,j,visited);
        dfs(i,j+1,visited);
    }
}
