package divideAndConquer;

public class 漂亮数组 {
    public int[] beautifulArray(int N) {
        if (N == 1) {
            return new int[]{1};
        }
        int[] odd = beautifulArray((N + 1) / 2);
        int[] even = beautifulArray(N / 2);
        int[] res = new int[N];
        for (int i = 0; i < odd.length; i++) {
            res[i] = odd[i] * 2 - 1;
        }
        for (int i = 0; i < even.length; i++) {
            res[i + odd.length] = even[i] * 2;
        }
        return res;
    }
}
