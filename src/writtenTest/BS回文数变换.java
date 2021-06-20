import java.util.Scanner;

public class BS回文数变换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int l = 0;int r = chars.length-1;
        int ret = 0;
        int[] cost = new int[8];
        while (l<r) {
            if (chars[l]==chars[r]){
                l++;
                r--;
            } else {
                if (getCost(chars[l])<getCost(chars[r])){
                    ret+=getCost(chars[l]);
                    l++;
                } else {
                    ret+=getCost(chars[r]);
                    r--;
                }
            }
        }
        System.out.println(ret);
    }

    private static int getCost(char c){
        if (c=='1'){
            return 100;
        } else if (c=='2'){
            return 200;
        } else if (c=='3'){
            return 200;
        } else if (c=='4'){
            return 220;
        }
        return 0;
    }
}
