package JZOffer;

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int length = (int) Math.pow(10,n)-1;
        int[] res = new int[length];
        for (int i =0;i<length;i++){
            res[i] = i+1;
        }
        return res;
    }
}
