package explore.JZOffer;

public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public int addV2(int a, int b) {
        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }
        return addV2(a^b, (a&b) << 1);
    }
}
