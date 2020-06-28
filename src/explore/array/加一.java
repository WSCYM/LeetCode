package explore.array;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 加一
 * @Description
 *
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @createTime 2020-06-28 17:40:00
 */
public class 加一 {
    //末位+1并对10取余,判断该位是否为0，为0则依次对前一位进行同样的操作
    //首位+1为0时前面添加一位1
    public int[] plusOne(int[] digits) {
        for (int j = digits.length-1;j>=0;j--){
            if (indexIPlusOne(digits,j)!=0){
                break;
            } else {
                //憨憨操作,后面几位都是0就不用copy数组了
                if (j==0){
                    int[] res = new int[digits.length+1];
                    res[0] = 1;
                    System.arraycopy(digits,0,res,1,digits.length);
                    return res;
                }
            }

        }
        return digits;
    }

    private int indexIPlusOne(int[] digits,int i) {
        digits[i] = (digits[i]+1) % 10;
        return digits[i];
    }

    //
    //    public int[] plusOne(int[] digits) {
    //        int len = digits.length;
    //        for(int i = len - 1; i >= 0; i--) {
    //            digits[i]++;
    //            digits[i] %= 10;
    //            if(digits[i]!=0)
    //                return digits;
    //        }
    //        digits = new int[len + 1];
    //        digits[0] = 1;
    //        return digits;
    //    }


}
