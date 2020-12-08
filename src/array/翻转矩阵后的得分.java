package array;

public class 翻转矩阵后的得分 {
    public int matrixScore(int[][] A) {
        for(int[] row : A){
            if (row[0]==0){
                for (int j = 0;j<row.length;j++){
                    row[j] = (row[j] + 1)%2;
                }
            }
        }
        for (int col = 1;col<A[0].length;col++){
            int count = 0;
            for (int i = 0;i<A.length;i++){
                if (A[i][col]==0){
                    count+=1;
                }
            }
            if (count * 2>A.length){
                for (int i = 0;i<A.length;i++){
                    A[i][col] = (A[i][col]+1)%2;
                }
            }
        }
        int res = 0;
        for (int i = 0;i<A.length;i++) {
            int k = 0;
            for (int j = A[0].length-1;j>=0;j--){
                res += A[i][j] * Math.pow(2,k);
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new 翻转矩阵后的得分().matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}});
    }
}
