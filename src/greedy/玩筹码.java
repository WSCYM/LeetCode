package greedy;

public class 玩筹码 {
    public int minCostToMoveChips(int[] position) {
        int odd_count=0,evenCount=0;
        for (int i : position){
            if (i%2==0){
                evenCount++;
            } else {
                odd_count++;
            }
        }
        return Math.min(odd_count,evenCount);
    }
}
