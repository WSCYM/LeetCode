package bitManipulation;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int res = 0;
        while (z!=0){
            res += z % 2;
            z = z/2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new 汉明距离().hammingDistance(1,4)
        );
    }
}
