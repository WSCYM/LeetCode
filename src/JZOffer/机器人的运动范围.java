package JZOffer;

public class 机器人的运动范围 {

    public int movingCount(int m, int n, int k) {
        boolean[][] mask = new boolean[m][n];
        dfs(mask,0,0,k);
        int ret = 0;
        for (int i = 0;i<mask.length;i++){
            for (int j =0;j<mask[0].length;j++){
                if (mask[i][j]){
                    ret++;
                }
            }
        }
        return ret;
    }

    void dfs(boolean[][] mask,int i,int j,int k){
        if (i<0 || i>=mask.length || j<0 || j>=mask[0].length || mask[i][j] || !lessThanK(i,j,k)){
            return;
        }
        mask[i][j] = true;
        dfs(mask,i-1,j,k);
        dfs(mask,i+1,j,k);
        dfs(mask,i,j-1,k);
        dfs(mask,i,j+1,k);
    }

    boolean lessThanK(int m,int n,int k){
        int sum = 0;
        while (m>0){
            sum += m % 10;
            m/=10;
        }
        while (n>0){
            sum += n % 10;
            n/=10;
        }
        if (sum<=k){
            return true;
        } else {
            return false;
        }
    }
}
