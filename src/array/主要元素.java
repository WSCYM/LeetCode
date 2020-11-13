package array;

public class 主要元素 {
    public int majorityElement(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        int[][] res = new int[1][2];
        res[0][1] = 0;
        for (int i : nums){
            if (res[0][1]==0){
                res[0][0]=i;
                res[0][1]=1;
            } else {
                if (res[0][0]==i){
                    res[0][1]++;
                } else {
                    res[0][1]--;
                }
            }
        }
        if (res[0][1]==0){
            return -1;
        } else{
            int count=0;
            for (int i : nums){
                if (i==res[0][0]){
                    count++;
                }
            }
            if (count<=nums.length/2){
                return -1;
            } else {
                return res[0][0];
            }
        }
    }
}
