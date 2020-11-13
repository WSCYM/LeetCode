package array;

public class 找出数组游戏的赢家 {
    public int getWinner(int[] arr, int k) {
        //遍历一次，每次将p位置元素与当前元素比较，
        //若arr[p]>arr[i],则count++;
        //else则{p=i;count = 1}
        //遍历完一遍，则不论再进行几回合，均return arr[p]
        int p=0;
        int count=0;
        for (int i = 1;i<arr.length;i++){
            if (arr[p]>arr[i]){
                count++;
            } else {
                p=i;
                count=1;
            }
            if (count==k){
                return arr[p];
            }
        }
        return arr[p];
    }
}
