package math;

public class 水壶问题 {
    //问题可以转花为找到m和n使得mx + ny = k，其中m，n可以为正数或负数。
    // 对于这类问题，贝祖定理告诉我们，ax+by=z 有解当且仅当 zz 是 x, y 的最大公约数的倍数。
    // 因此我们只需要找到 x, y 的最大公约数并判断 z 是否是它的倍数即可。
    // 因此问题就转化为寻找x,y的最大公约数是否能整除k。
    public boolean canMeasureWater(int x, int y, int z) {
        if (x==0&&y==0) return z==0?true:false;
        if (x==0||y==0) return x==0?z%y==0:z%x==0;
        if(x+y<z) return false;
        if (z%gcd(x,y)==0){
            return true;
        } else return false;
    }

    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(new 水壶问题().gcd(3,5));
    }
}
