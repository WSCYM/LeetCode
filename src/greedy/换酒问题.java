package greedy;

public class 换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0,remain = 0;
        while (numBottles>0){
            res += numBottles;
            int tmpRemain = remain;
            remain = (numBottles+tmpRemain)%numExchange;
            numBottles = (numBottles+tmpRemain)/numExchange;

        }
        return res;
    }
}
