package JZOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流的中位数 {
}

//class MedianFinder {
//
//    ArrayList<Integer> arrayList = null;
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        arrayList = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        if (arrayList.size()==0) {
//            arrayList.add(num);
//        } else {
//            int i = 0;
//            while (i<arrayList.size() && num<arrayList.get(i)){
//                i++;
//            }
//            arrayList.add(i,num);
//        }
//    }
//
//    public double findMedian() {
//        if (arrayList.size()%2==0){
//            return ((double)arrayList.get(arrayList.size()/2-1)+(double)arrayList.get(arrayList.size()/2))/2;
//        } else {
//            return (double) arrayList.get(arrayList.size()/2);
//        }
//    }
//}

class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}