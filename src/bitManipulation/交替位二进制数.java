package bitManipulation;

public class 交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int n2 = n^n>>1;
        return (n2&(n2+1))==0?true:false;
    }

    public static void main(String[] args) {
        new 交替位二进制数().hasAlternatingBits(5);
    }
}
