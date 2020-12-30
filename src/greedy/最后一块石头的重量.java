package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 最后一块石头的重量 {
//    public int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
//        for (int i : stones){
//            queue.add(i);
//        }
//        while (queue.size()>=2){
//            Integer s1 = queue.remove();
//            Integer s2 = queue.remove();
//            Integer r = Math.abs(s1 - s2);
//            if (r!=0){
//                queue.add(r);
//            }
//        }
//        if (queue.size()==0){
//            return 0;
//        }
//        return queue.peek();
//    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i : stones){
            priorityQueue.add(i);
        }
        while (priorityQueue.size()>=2){
            Integer remove1 = priorityQueue.remove();
            Integer remove2 = priorityQueue.remove();
            if (remove1!=remove2){
                priorityQueue.add(Math.abs(remove1-remove2));
            }
        }
        if (priorityQueue.size()==0){
            return 0;
        }
        return priorityQueue.remove();
    }
}
