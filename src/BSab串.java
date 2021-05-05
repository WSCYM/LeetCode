import java.util.Scanner;

public class BSab串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] chars = string.toCharArray();
        long countB = 0;
        long ret = 0;
        for (int i = chars.length-1;i>=0;i--){
            if (chars[i]=='b'){
                countB=(countB+1)%1000000007;
            } else if (chars[i]=='a'){
                ret=(ret+countB)%1000000007;
                countB *=2;
            }
        }
        System.out.println(ret);
    }
}
