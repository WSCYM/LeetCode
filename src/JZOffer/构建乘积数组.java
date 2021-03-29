package JZOffer;

public class 构建乘积数组 {
    //O(n2)超时
//    public int[] constructArr(int[] a) {
//        int[] ret = new int[a.length];
//        for (int i = 0;i<a.length;i++){
//            int sum = 1;
//            for (int j = 0;j<a.length;j++){
//                if (j==i) continue;
//                sum*=a[j];
//            }
//            ret[i] = sum;
//        }
//        return ret;
//    }
    public int[] constructArr(int[] a) {
        int[] ret = new int[a.length];
        for (int i = 0;i<ret.length;i++){
            ret[i] = 1;
        }
        int tmp = 1;
        for (int i = 1;i<ret.length;i++){
            tmp *= a[i-1];
            ret[i] *= tmp;
        }
        tmp = 1;
        for (int i = ret.length-2;i>=0;i--){
            tmp *= a[i+1];
            ret[i] *= tmp;
        }
        return ret;
    }
}
