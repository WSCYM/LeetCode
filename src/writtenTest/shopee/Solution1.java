package writtenTest.shopee;

public class Solution1 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param petals int整型一维数组 花瓣数
     * @return int整型
     */
    int ret = 0;
    public int petalsBreak(int[] petals) {
        for (int num : petals){
            ret+= (num&1)==0 ? num/2:num/2+1;
        }
        return ret;
    }
}
