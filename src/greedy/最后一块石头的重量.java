package greedy;

import java.util.PriorityQueue;

public class 最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i : stones){
            queue.add(i);
        }
        while (queue.size()>=2){
            Integer s1 = queue.remove();
            Integer s2 = queue.remove();
            Integer r = Math.abs(s1 - s2);
            if (r!=0){
                queue.add(r);
            }
        }
        if (queue.size()==0){
            return 0;
        }
        return queue.peek();
    }
}
