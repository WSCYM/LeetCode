package greedy;

public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        if (flowerbed.length==1) {
            if (n==0){
                return true;
            }
            if (n==1 && flowerbed[0]==0){
                return true;
            }
            return false;
        }
        for (int i = 0;i<flowerbed.length;i++){
            if (i==0) {
                if (flowerbed[i]==0 && flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    num++;
                }
                continue;
            }
            if (i==flowerbed.length-1){
                if (flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i] = 1;
                    num++;
                }
                continue;
            }
            if (flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                num++;
            }
        }
        return num>=n;
    }
}
