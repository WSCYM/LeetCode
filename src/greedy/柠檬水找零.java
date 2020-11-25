package greedy;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int cnt5=0,cnt10=0;
        for (int i : bills){
            if (i==5){
                cnt5++;
            } else if (i==10){
                cnt5--;
                if (cnt5<0) return false;
                cnt10++;
            } else if (i==20){
                if (cnt10>=1){
                    cnt10--;
                    cnt5--;
                    if (cnt10<0 || cnt5<0){
                        return false;
                    }
                } else {
                    cnt5 -= 3;
                    if (cnt5<0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
