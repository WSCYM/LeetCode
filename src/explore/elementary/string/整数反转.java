package explore.elementary.string;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 整数反转
 * @Description
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @createTime 2020-07-03 10:38:00
 */
public class 整数反转 {
    public int reverse(int x) {
        int flag = (x<0)?-1:1;
        Long res = Long.valueOf(x);
        StringBuffer sb = new StringBuffer(String.valueOf(Math.abs(res))).reverse();
        String s = sb.toString();
        res = Long.parseLong(s) * flag;

        if (res<Integer.MAX_VALUE && res>Integer.MIN_VALUE){
            return Integer.parseInt(s) * flag;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 整数反转().reverse(Integer.MIN_VALUE));
    }
}
