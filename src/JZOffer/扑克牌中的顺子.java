package JZOffer;

import java.util.HashSet;

public class 扑克牌中的顺子 {
    int max = -1;
    int min = 14;
    HashSet<Integer> hashSet = new HashSet<>();
    public boolean isStraight(int[] nums) {
        for (int i : nums){
            if (i!=0) {
                if (hashSet.contains(i)){
                    return false;
                }
                hashSet.add(i);
                if (i>max){
                    max = i;
                }
                if (i<min){
                    min = i;
                }
            }
        }
        return (max-min)<5;
    }
}
