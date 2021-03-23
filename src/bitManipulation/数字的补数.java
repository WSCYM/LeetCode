package bitManipulation;

public class 数字的补数 {
    public int findComplement(int num) {
        int ret = 0;
        int i = 0;
        while (num>0){
            int k = num%2;
            if (k==0) {
                ret += (int) Math.pow(2,i);
            }
            num>>=1;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new 数字的补数().findComplement(5));
    }
}
