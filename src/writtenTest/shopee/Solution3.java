package writtenTest.shopee;

public class Solution3 {
    int ret = Integer.MIN_VALUE;
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        if (startPoint[0]==endPoint[0] && startPoint[1]==endPoint[1]){
            return 1;
        }
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        dfs(0,Integer.MAX_VALUE,startPoint[0],startPoint[1],rooms,endPoint,visited);
        return -ret+1;
    }

    void dfs(int health,int curMinVal,int i,int j,int[][] rooms, int[] endPoint,boolean[][] visited) {
        if (i<0 || i>= rooms.length || j<0 || j>=rooms[0].length ||visited[i][j]){
            return;
        }
        if (i==endPoint[0] && j==endPoint[1]){
            if (health+rooms[i][j]<curMinVal){
                curMinVal=health+rooms[i][j];
            }
           if (curMinVal>ret){
               ret = curMinVal;
           }
            return;
        }
        health = health+rooms[i][j];
        if (health<curMinVal){
            curMinVal = health;
        }
        visited[i][j] = true;
        dfs(health,curMinVal,i-1,j,rooms,endPoint,visited);
        dfs(health,curMinVal,i+1,j,rooms,endPoint,visited);
        dfs(health,curMinVal,i,j-1,rooms,endPoint,visited);
        dfs(health,curMinVal,i,j+1,rooms,endPoint,visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution3().minimumInitHealth(new int[][]{{-2,-3,3},{-5,-10,1}, {10,30,-5}},new int[]{0,0},new int[]{2,2}));;
        System.out.println(new Solution3().minimumInitHealth(new int[][]{{100}},new int[]{0,0},new int[]{0,0}));;
    }

}
