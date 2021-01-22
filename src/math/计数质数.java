package math;

public class 计数质数 {
    public int countPrimes(int n) {
        if (n<2) return 0;
        int[] arr = new int[n];
        for (int i = 2;i<n;i++){
            if (arr[i]*2>=n) break;
            for (int j = 2;i<n;j++){
                if (i*j>=n) break;
                arr[i*j] = 1;
            }
        }
        int cnt = 0;
        for (int i : arr){
            if (i == 0) cnt++;
        }
        return cnt-2;
    }

    public static void main(String[] args) {
        new 计数质数().countPrimes(5);
    }
}
