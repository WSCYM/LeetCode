package bitManipulation;

public class 颠倒二进制位 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0;i<32;i++){
            res = res << 1;
            res += n&1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 颠倒二进制位().reverseBits(2));;
    }
}
