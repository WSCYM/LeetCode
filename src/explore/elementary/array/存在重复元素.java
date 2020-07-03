package explore.elementary.array;

import java.util.Arrays;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 存在重复元素
 * @Description
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @createTime 2020-06-27 23:36:00
 */
public class 存在重复元素 {

    //用该方法超时，arrayList的search时间复杂度为o(n),可换成hashSet,hashSet的search时间复杂度o(1)
//    public boolean containsDuplicate(int[] nums) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (Integer i : nums){
//            if (arrayList.contains(i)){
//                return true;
//            }
//            arrayList.add(i);
//        }
//        return false;

        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }



}
