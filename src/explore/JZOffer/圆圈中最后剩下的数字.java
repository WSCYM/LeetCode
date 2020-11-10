package explore.JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i < n;i++){
            arrayList.add(i);
        }
        int idx = 0;
        while (arrayList.size()>=2){
            idx = (idx+m-1) % arrayList.size();
            arrayList.remove(idx);
        }
        return arrayList.get(0);
    }

    public static void main(String[] args) {
        new 圆圈中最后剩下的数字().lastRemaining(5,3);
    }
}
