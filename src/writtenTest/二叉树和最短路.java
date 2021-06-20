import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 二叉树和最短路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> rets= new ArrayList<>();
        for (int i =0;i<len;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            rets.add(getRet(n1,n2));
        }
        for (Integer i : rets){
            System.out.println(i);
        }
    }

     static int getRet(int n1,int n2){
        int ret = 0;
        while (n1!=n2){
            if (n1>n2) {
                n1>>=1;
            } else {
                n2>>=1;
            }
            ret++;
        }
        return ret;
    }
}
