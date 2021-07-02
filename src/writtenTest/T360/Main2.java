package writtenTest.T360;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        long cntB = 0;
        long ret = 0;
        for (int i = chars.length-1;i>=0;i--){
            if (chars[i]=='b'){
                cntB = (cntB+1)%1000000007;
            } else if (chars[i]=='a'){
                ret = (ret+cntB)%1000000007;
                cntB *=2;
            }
        }
        System.out.println(ret);
    }
}
