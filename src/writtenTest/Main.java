package writtenTest;

import java.util.Scanner;

public class Main {
    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxW = sc.nextInt();
        String[] weights = sc.next().split(",");
        String[] values = sc.next().split(",");
        boolean[] visited = new boolean[weights.length];
        backtrack(weights,values,visited,0,0,maxW);
        System.out.println(ret);
    }
    static void backtrack(String[] weights,String[] values,boolean[] visited,int sumVal,int sumW,int maxW){
        if (sumW>maxW){
            return;
        }
        if (sumVal>ret){
            ret=sumVal;
        }
        for (int i=0;i<weights.length;i++){
            if (visited[i]){
                continue;
            }
            visited[i]=true;
            backtrack(weights, values, visited, sumVal+Integer.valueOf(values[i]), sumW+Integer.valueOf(weights[i]), maxW);
            visited[i]=false;
        }
    }
}
