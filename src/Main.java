import classes.ListNode;

import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0;i<n;i++){
            int val = sc.nextInt();
            if (i!=m-1){
                System.out.print(val+" ");
            }
        }
    }
}