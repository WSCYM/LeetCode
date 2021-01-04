package sort;

import java.util.Arrays;
import java.util.Comparator;

public class 你可以获得的最大硬币数目 {
//    public int maxCoins(int[] piles) {
//        Integer[] arr = Arrays.stream(piles).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr,(o1,o2)->o2-o1);
//        int idx = 1;
//        int res = 0;
//        while (idx*3<=arr.length){
//            res += arr[(idx-1)*2+1];
//            idx++;
//        }
//        return res;
//    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l=0;
        int r = piles.length-1;
        int res = 0;
        while (l<=r){
            l++;
            r--;
            res += piles[r];
            r--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 你可以获得的最大硬币数目().maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}
