package JZOffer;

public class 数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int n : nums){
            tmp ^= n;
        }
        tmp = tmp & -tmp;
        int[] res = new int[2];
        for (int n : nums){
            if ((n & tmp) == 0){
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
