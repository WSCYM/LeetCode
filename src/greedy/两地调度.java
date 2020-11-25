package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class 两地调度 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(o1,o2)->Math.abs(o2[0]-o2[1])-Math.abs(o1[0]-o1[1]));
        int sum = 0;
        ArrayList<Integer> a = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        int i = 0;
        while (a.size()!=costs.length/2 && b.size()!=costs.length/2){
            if (costs[i][0]<costs[i][1]){
                a.add(costs[i][0]);
            } else {
                b.add(costs[i][1]);
            }
            i++;
        }
        if (a.size()==costs.length/2){
            while (i<costs.length){
                sum+=costs[i][1];
                i++;
            }
        } else {
            while (i<costs.length){
                sum+=costs[i][0];
                i++;
            }
        }
        for (Integer cost: a){
            sum+=cost;
        }
        for (Integer cost: b){
            sum+=cost;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 两地调度().twoCitySchedCost(new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}}));
    }
}
