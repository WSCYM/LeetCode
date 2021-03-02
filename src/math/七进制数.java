package math;

public class 七进制数 {
    public String convertToBase7(int num) {
        if (num==0) return "0";
        StringBuffer res = new StringBuffer();
        boolean lowThanZero = num<0?true:false;
        num = Math.abs(num);
        while (num>0){
            int i = num % 7;
            res.insert(0,i);
            num /=7;
        }
        if (lowThanZero) res.insert(0,"-");
        return res.toString();
    }
}
