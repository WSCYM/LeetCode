package JZOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Proc{
    String pName;
    Integer enterTime;
    Integer operateTime;
    Integer remainTime;
    Boolean hasEnter = false;
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
            proc.remainTime = proc.operateTime;
            as.add(proc);
        }
        Proc p1 = as.get(0);
        Proc p2 = as.get(1);
        Proc p3 = as.get(2);
        int t = 0;
        while (true){
            if (p1.enterTime == t && !p1.hasEnter) {
                p1.hasEnter=true;
                sortByRemainTime(as);
            } else if (p2.enterTime == t && !p2.hasEnter) {
                p2.hasEnter = true;
                sortByRemainTime(as);
            } else if (p3.enterTime == t && !p2.hasEnter) {
                p3.hasEnter = true;
                sortByRemainTime(as);
            }
            as.get(0).remainTime--;
            if (as.get(0).remainTime==0){
                as.remove(0);
            }
            if (as.size()==1){
                break;
            }
            t++;
        }
        System.out.printf(as.get(0).pName);
    }

    public static ArrayList<Proc> sortByRemainTime(ArrayList<Proc> as){
        //按剩余时间排序,若剩余时间相同，按进入时间反向排序
        as.sort(new Comparator<Proc>() {
            @Override
            public int compare(Proc o1, Proc o2) {
                if (o1.remainTime==o2.remainTime){
                    return o2.enterTime-o1.enterTime;
                } else return o1.remainTime-o2.remainTime;
            }
        });
        return as;
    }
}
