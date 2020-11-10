package JZOffer;

import java.util.ArrayList;
import java.util.Scanner;

class Proc{
    String pName;
    Integer enterTime;
    Integer operateTime;
}

public class Test {
    public static void main(String[] args) {
        //读取输入的数据，讲三个进程放到arrayList中
        Scanner sc = new Scanner(System.in);
        ArrayList<Proc> as = new ArrayList<>();
        for (int i=0;i<3;i++){
            Proc proc = new Proc();
            proc.pName = sc.next();
            proc.enterTime = sc.nextInt();
            proc.operateTime = sc.nextInt();
            as.add(proc);
        }
//      先执行的进程为最先进入的进程，所以遍历三个进程，找到进入时间最小的进程，即为最先执行的进程
        Proc first = new Proc();
        first.enterTime = Integer.MAX_VALUE;
        for (Proc p : as){
            if (p.enterTime<first.enterTime){
                first = p;
            }
        }
//        firstEndTime为第一个进程的结束时间
        Integer firstEndTime = first.enterTime+first.operateTime;
//        执行完后将第一个进程移除
        as.remove(first);

//        下面四行计算剩余两个进程的响应比
        Double rate1,rate2;
        Proc proc1 = as.get(0);
        rate1 = Double.valueOf(1+((firstEndTime-proc1.enterTime)/proc1.operateTime));
        Proc proc2 = as.get(1);
        rate2 = Double.valueOf(1+((firstEndTime-proc2.enterTime)/proc2.operateTime));

//        响应比相同,则先执行前面的进程，所以最后执行进程proc2
        if (rate1.equals(rate2)){
            System.out.println(proc2.pName);
//            若proc1响应比高，则先执行proc1，最后执行进程proc2
        } else if (rate1.compareTo(rate2)>0){
            System.out.println(proc2.pName);
        } else {
//            若proc2响应比高，则先执行proc2，最后执行进程proc1
            System.out.println(proc1.pName);
        }
    }
}
