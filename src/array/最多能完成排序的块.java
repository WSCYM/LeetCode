package array;

public class 最多能完成排序的块 {
    public int maxChunksToSorted(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>maxNum){
                maxNum = arr[i];
            }
            if (i>=maxNum) {
                ret++;
            }
        }
        return ret;
    }
}
